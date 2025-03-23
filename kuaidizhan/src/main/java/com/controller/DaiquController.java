package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JiedanEntity;
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

import com.entity.DaiquEntity;

import com.entity.view.DaiquView;
import com.entity.YonghuEntity;
import com.entity.ZhandianEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 待取件表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-11
*/
@RestController
@Controller
@RequestMapping("/daiqu")
public class DaiquController {
    private static final Logger logger = LoggerFactory.getLogger(DaiquController.class);

    @Autowired
    private DaiquService daiquService;

    @Autowired
    private JiedanService jiedanService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
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
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = daiquService.queryPage(params);

        //字典表数据转换
        List<DaiquView> list =(List<DaiquView>)page.getList();
        for(DaiquView c:list){
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
        DaiquEntity daiqu = daiquService.selectById(id);
        if(daiqu !=null){
            //entity转view
            DaiquView view = new DaiquView();
            BeanUtils.copyProperties( daiqu , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(daiqu.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            ZhandianEntity zhandian = zhandianService.selectById(daiqu.getZhandianId());
            if(zhandian != null){
                BeanUtils.copyProperties( zhandian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZhandianId(zhandian.getId());
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
    public R save(@RequestBody DaiquEntity daiqu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daiqu:{}",this.getClass().getName(),daiqu.toString());
        daiqu.setKdztTypes(1);
        daiqu.setTakecode(UUID.randomUUID().toString().toString().replace("-","").substring(0,6));
        Wrapper<DaiquEntity> queryWrapper = new EntityWrapper<DaiquEntity>()
            .eq("dqname", daiqu.getDqname())
            .eq("zhandian_id", daiqu.getZhandianId())
            .eq("yonghu_id", daiqu.getYonghuId())
            .eq("takecode", daiqu.getTakecode())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiquEntity daiquEntity = daiquService.selectOne(queryWrapper);
        if(daiquEntity==null){
            daiquService.insert(daiqu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaiquEntity daiqu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,daiqu:{}",this.getClass().getName(),daiqu.toString());
        //根据字段查询是否有相同数据
        Wrapper<DaiquEntity> queryWrapper = new EntityWrapper<DaiquEntity>()
            .notIn("id",daiqu.getId())
            .eq("dqname", daiqu.getDqname())
            .eq("zhandian_id", daiqu.getZhandianId())
            .eq("yonghu_id", daiqu.getYonghuId())
            .eq("kddx_types", daiqu.getKddxTypes())
            .eq("dqphone", daiqu.getDqphone())
            .eq("takecode", daiqu.getTakecode())
            .eq("kdzt_types", daiqu.getKdztTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiquEntity daiquEntity = daiquService.selectOne(queryWrapper);
                daiqu.setPickupTime(new Date());
        if(daiquEntity==null){
            daiquService.updateById(daiqu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 代取订单
    */
    @RequestMapping("/replaceExpress")
    public R replaceExpress(@RequestBody Integer ids){
        DaiquEntity daiqu = daiquService.selectById(ids);
        if(daiqu == null){
            return R.error("数据不存在");
        }
        YonghuEntity yonghu = yonghuService.selectById(daiqu.getYonghuId());
        if(yonghu == null){
            return R.error("数据不存在");
        }
        JiedanEntity jiedan = new JiedanEntity();
        jiedan.setInitiateTime(new Date());
        jiedan.setJdyonghuId(daiqu.getYonghuId());
        jiedan.setJdphone(daiqu.getDqphone());
        jiedan.setAddresseename(yonghu.getName());
        jiedan.setJdaddressee("住宿楼栋："+yonghu.getDormitory()+" ，寝室号："+yonghu.getDormitory());
        jiedan.setJdtakecode(daiqu.getTakecode());
        jiedan.setDaiqukuaidimc(daiqu.getDqname());
        jiedan.setJdztTypes(1);//1未接
        jiedan.setKdlxTypes(1);//1取件
        jiedan.setOdd(String.valueOf(new Date().getTime()));
        Wrapper<JiedanEntity> queryWrapper = new EntityWrapper<JiedanEntity>()
                .eq("jdyonghu_id", jiedan.getJdyonghuId())
                .eq("jdtakecode", jiedan.getJdtakecode())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedanEntity jiedanEntity = jiedanService.selectOne(queryWrapper);
        if(jiedanEntity==null){
            daiqu.setKdztTypes(3);
            daiquService.updateById(daiqu);
            jiedanService.insert(jiedan);
            return R.ok();
        }else {
            return R.error(511,"你已经发布过这件快递的代取订单了");
        }
    }


    /**
    * 取件
    */
    @RequestMapping("/pickUp")
    public R pickUp(@RequestBody Integer ids){
        DaiquEntity daiqu = daiquService.selectById(ids);
        if(daiqu == null){
            return R.error("数据不存在");
        }
        daiqu.setKdztTypes(2);
        daiqu.setPickupTime(new Date());
        daiquService.updateById(daiqu);
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        daiquService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

