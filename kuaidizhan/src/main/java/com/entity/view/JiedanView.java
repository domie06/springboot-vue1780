package com.entity.view;

import com.entity.JiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递接单表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("jiedan")
public class JiedanView extends JiedanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 快递状态的值
		*/
		private String jdztValue;
		/**
		* 快递类型的值
		*/
		private String kdlxValue;

		private String fbrname;



	public JiedanView() {

	}

	public JiedanView(JiedanEntity jiedanEntity) {
		try {
			BeanUtils.copyProperties(this, jiedanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFbrname() {
		return fbrname;
	}

	public void setFbrname(String fbrname) {
		this.fbrname = fbrname;
	}

	/**
			* 获取： 快递状态的值
			*/
			public String getJdztValue() {
				return jdztValue;
			}
			/**
			* 设置： 快递状态的值
			*/
			public void setJdztValue(String jdztValue) {
				this.jdztValue = jdztValue;
			}
			/**
			* 获取： 快递类型的值
			*/
			public String getKdlxValue() {
				return kdlxValue;
			}
			/**
			* 设置： 快递类型的值
			*/
			public void setKdlxValue(String kdlxValue) {
				this.kdlxValue = kdlxValue;
			}


























}
