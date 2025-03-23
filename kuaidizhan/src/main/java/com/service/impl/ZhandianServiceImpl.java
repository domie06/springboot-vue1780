package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ZhandianDao;
import com.entity.ZhandianEntity;
import com.service.ZhandianService;
import com.entity.view.ZhandianView;

/**
 * 快递站点 服务实现类
 * @author 
 * @since 2021-03-11
 */
@Service("zhandianService")
@Transactional
public class ZhandianServiceImpl extends ServiceImpl<ZhandianDao, ZhandianEntity> implements ZhandianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZhandianView> page =new Query<ZhandianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
