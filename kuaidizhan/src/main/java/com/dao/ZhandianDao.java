package com.dao;

import com.entity.ZhandianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhandianView;

/**
 * 快递站点 Dao 接口
 *
 * @author 
 * @since 2021-03-11
 */
public interface ZhandianDao extends BaseMapper<ZhandianEntity> {

   List<ZhandianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
