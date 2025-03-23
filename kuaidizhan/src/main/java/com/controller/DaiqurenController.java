package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.DaiqurenEntity;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.DaiqurenEntity;

import com.service.DaiqurenService;
import com.entity.view.DaiqurenView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-03-11
*/
@RestController
@Controller
@RequestMapping("/daiquren")
public class DaiqurenController {
    private static final Logger logger = LoggerFactory.getLogger(DaiqurenController.class);

    @Autowired
    private DaiqurenService daiqurenService;


    @Autowired
    private TokenService tokenService;
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
        if(StringUtil.isNotEmpty(role) && "代取人".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = daiqurenService.queryPage(params);

        //字典表数据转换
        List<DaiqurenView> list =(List<DaiqurenView>)page.getList();
        for(DaiqurenView c:list){
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
        DaiqurenEntity daiquren = daiqurenService.selectById(id);
        if(daiquren !=null){
            //entity转view
            DaiqurenView view = new DaiqurenView();
            BeanUtils.copyProperties( daiquren , view );//把实体数据重构到view中

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
    public R save(@RequestBody DaiqurenEntity daiquren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daiquren:{}",this.getClass().getName(),daiquren.toString());
        Wrapper<DaiqurenEntity> queryWrapper = new EntityWrapper<DaiqurenEntity>()
            .eq("name", daiquren.getName())
            .eq("username", daiquren.getUsername())
            .eq("password", daiquren.getPassword())
            .eq("sex_types", daiquren.getSexTypes())
            .eq("phone", daiquren.getPhone())
            .eq("role", daiquren.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiqurenEntity daiqurenEntity = daiqurenService.selectOne(queryWrapper);
        if(daiqurenEntity==null){
            daiquren.setRole("代取人");
            daiqurenService.insert(daiquren);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaiqurenEntity daiquren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,daiquren:{}",this.getClass().getName(),daiquren.toString());
        //根据字段查询是否有相同数据
        Wrapper<DaiqurenEntity> queryWrapper = new EntityWrapper<DaiqurenEntity>()
            .notIn("id",daiquren.getId())
            .eq("name", daiquren.getName())
            .eq("username", daiquren.getUsername())
            .eq("password", daiquren.getPassword())
            .eq("sex_types", daiquren.getSexTypes())
            .eq("phone", daiquren.getPhone())
            .eq("role", daiquren.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaiqurenEntity daiqurenEntity = daiqurenService.selectOne(queryWrapper);
        if("".equals(daiquren.getImgPhoto()) || "null".equals(daiquren.getImgPhoto())){
                daiquren.setImgPhoto(null);
        }
        if(daiqurenEntity==null){
            daiqurenService.updateById(daiquren);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        daiqurenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        DaiqurenEntity yonghu = daiqurenService.selectOne(new EntityWrapper<DaiqurenEntity>().eq("username", username));
        if(yonghu==null || !yonghu.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!role.equals(yonghu.getRole())){
            return R.error("权限不正确");
        }
        String token = tokenService.generateToken(yonghu.getId(),username, "yonghu", "代取人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","代取人");
        r.put("userId",yonghu.getId());
        return r;
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody DaiqurenEntity yonghu){
        //    	ValidatorUtils.validateEntity(user);
        if(daiqurenService.selectOne(new EntityWrapper<DaiqurenEntity>().eq("username", yonghu.getUsername()).orNew().eq("phone",yonghu.getPhone())) !=null) {
            return R.error("代取人已存在或手机号身份证号已经被使用");
        }
        daiqurenService.insert(yonghu);
        return R.ok();
    }

    /**
     * 获取代取人的session代取人信息
     */
    @RequestMapping("/session")
    public R getCurrYonghu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        DaiqurenEntity yonghu = daiqurenService.selectById(id);
        return R.ok().put("data", yonghu);
    }


    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


}

