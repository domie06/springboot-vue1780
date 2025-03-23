package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaiquEntity;
import java.util.Map;

/**
 * 待取件表 服务类
 * @author 
 * @since 2021-03-11
 */
public interface DaiquService extends IService<DaiquEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}