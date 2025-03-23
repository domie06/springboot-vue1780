package com.dao;

import com.entity.DaiquEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaiquView;

/**
 * 待取件表 Dao 接口
 *
 * @author 
 * @since 2021-03-11
 */
public interface DaiquDao extends BaseMapper<DaiquEntity> {

   List<DaiquView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
