package com.entity.view;

import com.entity.YijiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 已接单表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("yijiedan")
public class YijiedanView extends YijiedanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 订单状态的值
		*/
		private String ddztValue;



		//级联表 daiquren
			/**
			* 用户名称
			*/
			private String yhname;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 联系电话
			*/
			private String phone;
			/**
			* 身份
			*/
			private String role;

		//级联表 yonghu
			/**
			* 学号
			*/
			private String studentnumber;

			private String name;


			/**
			* 住宿楼栋
			*/
			private String zhuSuLou;
			/**
			* 寝室号
			*/
			private String dormitory;
	public YijiedanView() {

	}

	public YijiedanView(YijiedanEntity yijiedanEntity) {
		try {
			BeanUtils.copyProperties(this, yijiedanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单状态的值
			*/
			public String getDdztValue() {
				return ddztValue;
			}
			/**
			* 设置： 订单状态的值
			*/
			public void setDdztValue(String ddztValue) {
				this.ddztValue = ddztValue;
			}













				//级联表的get和set yonghu
					/**
					* 获取： 学号
					*/
					public String getStudentnumber() {
						return studentnumber;
					}
					/**
					* 设置： 学号
					*/
					public void setStudentnumber(String studentnumber) {
						this.studentnumber = studentnumber;
					}

					public String getYhname() {
						return yhname;
					}

					public void setYhname(String yhname) {
						this.yhname = yhname;
					}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 头像
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 联系电话
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 联系电话
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 住宿楼栋
					*/
					public String getZhuSuLou() {
						return zhuSuLou;
					}
					/**
					* 设置： 住宿楼栋
					*/
					public void setZhuSuLou(String zhuSuLou) {
						this.zhuSuLou = zhuSuLou;
					}
					/**
					* 获取： 寝室号
					*/
					public String getDormitory() {
						return dormitory;
					}
					/**
					* 设置： 寝室号
					*/
					public void setDormitory(String dormitory) {
						this.dormitory = dormitory;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}







}
