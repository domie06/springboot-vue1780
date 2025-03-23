package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YijiedanEntity;
import java.util.Map;

/**
 * 已接单表 服务类
 * @author 
 * @since 2021-03-11
 */
public interface YijiedanService extends IService<YijiedanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}