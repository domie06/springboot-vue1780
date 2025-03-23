package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
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

import com.entity.view.YijiedanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 已接单表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-11
*/
@RestController
@Controller
@RequestMapping("/yijiedan")
public class YijiedanController {
    private static final Logger logger = LoggerFactory.getLogger(YijiedanController.class);

    @Autowired
    private YijiedanService yijiedanService;

    @Autowired
    private JiedanService jiedanService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DaiquService daiquService;

    //级联表service
    @Autowired
    private DaiqurenService daiqurenService;

    @Autowired
    private YonghuService yonghuService;


    @Autowired
    private ZhandianService zhandianService;

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
            page = yijiedanService.queryPage(params);
        }else if(StringUtil.isNotEmpty(role) && "代取人".equals(role)){
            params.put("daiqurenId",request.getSession().getAttribute("userId"));
            page = yijiedanService.queryPage(params);
        }
        page = yijiedanService.queryPage(params);

        //字典表数据转换
        List<YijiedanView> list =(List<YijiedanView>)page.getList();
        for(YijiedanView c:list){
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
        YijiedanEntity yijiedan = yijiedanService.selectById(id);
        if(yijiedan !=null){
            //entity转view
            YijiedanView view = new YijiedanView();
            BeanUtils.copyProperties( yijiedan , view );//把实体数据重构到view中

            //级联表
            DaiqurenEntity daiquren = daiqurenService.selectById(yijiedan.getDaiqurenId());
            if(daiquren != null){
                view.setDaiqurenId(daiquren.getId());
                view.setYhname(daiquren.getName());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yijiedan.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody YijiedanEntity yijiedan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yijiedan:{}",this.getClass().getName(),yijiedan.toString());
        Wrapper<YijiedanEntity> queryWrapper = new EntityWrapper<YijiedanEntity>()
            .eq("odd", yijiedan.getOdd())
            .eq("yonghu_id", yijiedan.getYonghuId())
            .eq("fbphone", yijiedan.getFbphone())
            .eq("daiquren_id", yijiedan.getDaiqurenId())
            .eq("jdphone", yijiedan.getJdphone())
            .eq("ddzt_types", yijiedan.getDdztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YijiedanEntity yijiedanEntity = yijiedanService.selectOne(queryWrapper);
        if(yijiedanEntity==null){
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yijiedan.set
        //  }
            yijiedanService.insert(yijiedan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YijiedanEntity yijiedan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yijiedan:{}",this.getClass().getName(),yijiedan.toString());
        //根据字段查询是否有相同数据
        Wrapper<YijiedanEntity> queryWrapper = new EntityWrapper<YijiedanEntity>()
            .notIn("id",yijiedan.getId())
            .eq("odd", yijiedan.getOdd())
            .eq("yonghu_id", yijiedan.getYonghuId())
            .eq("fbphone", yijiedan.getFbphone())
            .eq("daiquren_id", yijiedan.getDaiqurenId())
            .eq("jdphone", yijiedan.getJdphone())
            .eq("ddzt_types", yijiedan.getDdztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YijiedanEntity yijiedanEntity = yijiedanService.selectOne(queryWrapper);
                yijiedan.setInitiateTime(new Date());
        if(yijiedanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yijiedan.set
            //  }
            yijiedanService.updateById(yijiedan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 完成
    */
    @RequestMapping("/accomplish")
    public R accomplish(@RequestBody Integer ids){
        YijiedanEntity yijiedan = yijiedanService.selectById(ids);
        if(yijiedan == null){
            return  R.error();
        }
        JiedanEntity odd = jiedanService.selectOne(new EntityWrapper<JiedanEntity>().eq("odd", yijiedan.getOdd()));
        if(odd == null){
            return R.error();
        }
        if(odd.getKdlxTypes() == 1){
            DaiquEntity takecode = daiquService.selectOne(new EntityWrapper().eq("takecode", odd.getJdtakecode()));
            if(takecode == null){
                return  R.error();
            }
            takecode.setKdztTypes(2);

            takecode.setPickupTime(new Date());
            daiquService.updateById(takecode);
        }else{
            DaiquEntity daiqu = new DaiquEntity();
            List<ZhandianEntity> zhandian = zhandianService.selectList(null);
            int max=zhandian.size()-1,min=0;
            int ran2 = (int) (Math.random()*(max-min)+min);
            //随机站点
            daiqu.setZhandianId(zhandian.get(ran2).getId());
            //快递名称
            daiqu.setDqname(odd.getDaiqukuaidimc());
            //快递大小
            daiqu.setKddxTypes(odd.getDx());
            daiqu.setKdztTypes(1);
            //收件用户id
            YonghuEntity name = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("name", odd.getAddresseename()));
            daiqu.setYonghuId(name.getId());
            //手机号
            daiqu.setDqphone(name.getPhone());
            //取件码
            daiqu.setTakecode(UUID.randomUUID().toString().toString().replace("-","").substring(0,6));
            daiquService.insert(daiqu);
        }
        yijiedan.setDdztTypes(2);//2已完成
        yijiedanService.updateById(yijiedan);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yijiedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

