package com.dao;

import com.entity.DaiqurenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaiqurenView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-03-11
 */
public interface DaiqurenDao extends BaseMapper<DaiqurenEntity> {

   List<DaiqurenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
