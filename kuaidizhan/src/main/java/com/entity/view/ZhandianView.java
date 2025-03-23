package com.entity.view;

import com.entity.ZhandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递站点
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("zhandian")
public class ZhandianView extends ZhandianEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public ZhandianView() {

	}

	public ZhandianView(ZhandianEntity zhandianEntity) {
		try {
			BeanUtils.copyProperties(this, zhandianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













}
