package com.entity.view;

import com.entity.DaiquEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 待取件表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("daiqu")
public class DaiquView extends DaiquEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 快递大小的值
		*/
		private String kddxValue;
		/**
		* 快递状态的值
		*/
		private String kdztValue;



		//级联表 yonghu
			/**
			* 学号
			*/
			private String studentnumber;
			/**
			* 用户名称
			*/
			private String name;
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
			* 住宿楼栋
			*/
			private String zhuSuLou;
			/**
			* 寝室号
			*/
			private String dormitory;
			/**
			* 身份
			*/
			private String role;

		//级联表 zhandian
			/**
			* 站点名称
			*/
			private String zdname;
			/**
			* 站点地址
			*/
			private String address;

	public DaiquView() {

	}

	public DaiquView(DaiquEntity daiquEntity) {
		try {
			BeanUtils.copyProperties(this, daiquEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 快递大小的值
			*/
			public String getKddxValue() {
				return kddxValue;
			}
			/**
			* 设置： 快递大小的值
			*/
			public void setKddxValue(String kddxValue) {
				this.kddxValue = kddxValue;
			}
			/**
			* 获取： 快递状态的值
			*/
			public String getKdztValue() {
				return kdztValue;
			}
			/**
			* 设置： 快递状态的值
			*/
			public void setKdztValue(String kdztValue) {
				this.kdztValue = kdztValue;
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
					/**
					* 获取： 用户名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 用户名称
					*/
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


				//级联表的get和set zhandian
					/**
					* 获取： 站点名称
					*/
					public String getZdname() {
						return zdname;
					}
					/**
					* 设置： 站点名称
					*/
					public void setZdname(String zdname) {
						this.zdname = zdname;
					}
					/**
					* 获取： 站点地址
					*/
					public String getAddress() {
						return address;
					}
					/**
					* 设置： 站点地址
					*/
					public void setAddress(String address) {
						this.address = address;
					}




}
