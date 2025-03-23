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

import com.dao.DaiquDao;
import com.entity.DaiquEntity;
import com.service.DaiquService;
import com.entity.view.DaiquView;

/**
 * 待取件表 服务实现类
 * @author 
 * @since 2021-03-11
 */
@Service("daiquService")
@Transactional
public class DaiquServiceImpl extends ServiceImpl<DaiquDao, DaiquEntity> implements DaiquService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DaiquView> page =new Query<DaiquView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
