package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.DaiqurenEntity;
import com.entity.YijiedanEntity;
import com.entity.YonghuEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiedanEntity;

import com.entity.view.JiedanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递接单表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-11
*/
@RestController
@Controller
@RequestMapping("/jiedan")
public class JiedanController {
    private static final Logger logger = LoggerFactory.getLogger(JiedanController.class);

    @Autowired
    private YijiedanService yijiedanService;

    @Autowired
    private JiedanService jiedanService;

    @Autowired
    private DaiqurenService daiqurenService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        PageUtils page = null;
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            page = jiedanService.queryPage(params);
        }
         page = jiedanService.queryPage(params);
        //字典表数据转换
        List<JiedanView> list =(List<JiedanView>)page.getList();
        for(JiedanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiedanEntity jiedan = jiedanService.selectById(id);
        if(jiedan !=null){
            //entity转view
            JiedanView view = new JiedanView();
            BeanUtils.copyProperties( jiedan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiedanEntity jiedan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiedan:{}",this.getClass().getName(),jiedan.toString());
        Wrapper<JiedanEntity> queryWrapper = new EntityWrapper<JiedanEntity>()
            .eq("addresseename", jiedan.getAddresseename())
            .eq("jdphone", jiedan.getJdphone())
            .eq("jdaddressee", jiedan.getJdaddressee())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanEntity jiedanEntity = jiedanService.selectOne(queryWrapper);
        if(jiedanEntity==null){
            jiedanService.insert(jiedan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiedanEntity jiedan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiedan:{}",this.getClass().getName(),jiedan.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiedanEntity> queryWrapper = new EntityWrapper<JiedanEntity>()
            .notIn("id",jiedan.getId())
            .eq("odd", jiedan.getOdd())
            .eq("daiqukuaidimc", jiedan.getDaiqukuaidimc())
            .eq("jdyonghu_id", jiedan.getJdyonghuId())
            .eq("addresseename", jiedan.getAddresseename())
            .eq("jdphone", jiedan.getJdphone())
            .eq("jdaddressee", jiedan.getJdaddressee())
            .eq("jdtakecode", jiedan.getJdtakecode())
            .eq("jdzt_types", jiedan.getJdztTypes())
            .eq("kdlx_types", jiedan.getKdlxTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanEntity jiedanEntity = jiedanService.selectOne(queryWrapper);
                jiedan.setInitiateTime(new Date());
        if(jiedanEntity==null){
            jiedanService.updateById(jiedan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 接单
    */
    @RequestMapping("/receiving")
    public R receiving(@RequestBody Integer ids, HttpServletRequest request){
        JiedanEntity jiedan = jiedanService.selectById(ids);
        if(jiedan == null){
            return R.error();
        }
        if(request.getSession().getAttribute("role").equals("代取人")){
            DaiqurenEntity userId = daiqurenService.selectById((Integer) request.getSession().getAttribute("userId"));

            jiedan.setJdztTypes(2);//以接
            YijiedanEntity yijiedan = new YijiedanEntity();
            yijiedan.setOdd(jiedan.getOdd());
            yijiedan.setYonghuId(jiedan.getJdyonghuId());
            yijiedan.setFbphone(jiedan.getJdphone());
            yijiedan.setDaiqurenId(userId.getId());
            yijiedan.setJdphone(userId.getPhone());
            yijiedan.setInitiateTime(new Date());
            yijiedan.setDdztTypes(1);//1正在路上

            Wrapper<YijiedanEntity> queryWrapper = new EntityWrapper<YijiedanEntity>()
                    .eq("odd", yijiedan.getOdd())
                    ;
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            YijiedanEntity yijiedanEntity = yijiedanService.selectOne(queryWrapper);
            if(yijiedanEntity==null){
                jiedanService.updateById(jiedan);
                yijiedanService.insert(yijiedan);
                return R.ok();
            }else {
                return R.error(511,"表中有相同数据");
            }
        }
        return R.error("***");
    }


    /**
    * 删除
    */
    @RequestMapping("/ship")
    public R ship(String name, Integer yh, Integer dx, HttpServletRequest request){
        if(name == null && name == "null" && name == ""){
            return R.error("快递名称不能为空");
        }
        if(yh == null && yh == 0){
            return R.error("收件人不能为空");
        }

        YonghuEntity yonghu = yonghuService.selectById(yh);
        if(yonghu == null){
            return R.error();
        }
        if(yonghu.getId() == (Integer)request.getSession().getAttribute("userId")){
            return R.error("发件人和收件人不能相同");
        }
        JiedanEntity jiedan = new JiedanEntity();
        jiedan.setOdd(String.valueOf(new Date().getTime()));
        jiedan.setDaiqukuaidimc(name);
        jiedan.setDx(dx);
        jiedan.setJdyonghuId((Integer)request.getSession().getAttribute("userId"));
        jiedan.setJdphone(yonghu.getPhone());
        jiedan.setInitiateTime(new Date());
        jiedan.setAddresseename(yonghu.getName());
        jiedan.setJdaddressee("住宿楼栋："+yonghu.getDormitory()+" ，寝室号："+yonghu.getDormitory());
        jiedan.setJdtakecode(UUID.randomUUID().toString().toString().replace("-","").substring(0,6));
        jiedan.setJdztTypes(1);//1未接
        jiedan.setKdlxTypes(2);//2寄件
        Wrapper<JiedanEntity> queryWrapper = new EntityWrapper<JiedanEntity>()
                .eq("addresseename", jiedan.getAddresseename())
                .eq("jdphone", jiedan.getJdphone())
                .eq("jdaddressee", jiedan.getJdaddressee())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanEntity jiedanEntity = jiedanService.selectOne(queryWrapper);
        if(jiedanEntity==null){
            jiedanService.insert(jiedan);
            return R.ok();
        }else {
            return R.error(511,"已经有相同的数据了");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

