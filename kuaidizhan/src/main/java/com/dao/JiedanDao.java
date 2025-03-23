package com.dao;

import com.entity.JiedanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiedanView;

/**
 * 快递接单表 Dao 接口
 *
 * @author 
 * @since 2021-03-11
 */
public interface JiedanDao extends BaseMapper<JiedanEntity> {

   List<JiedanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
