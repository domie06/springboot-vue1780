package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("yonghu")
public class YonghuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuEntity() {

	}

	public YonghuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 学号
     */
    @TableField(value = "studentnumber")

    private String studentnumber;


    /**
     * 用户名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 账号
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;
    @TableField(value = "yanzheng")
    private Integer yanzheng;

    public Integer getYanzheng() {
        return yanzheng;
    }

    public void setYanzheng(Integer yanzheng) {
        this.yanzheng = yanzheng;
    }

    /**
     * 头像
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 联系电话
     */
    @TableField(value = "phone")

    private String phone;


    /**
     * 住宿楼栋
     */
    @TableField(value = "zhuSuLou")

    private String zhuSuLou;


    /**
     * 寝室号
     */
    @TableField(value = "dormitory")

    private String dormitory;


    /**
     * 身份
     */
    @TableField(value = "role")

    private String role;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学号
	 */
    public String getStudentnumber() {
        return studentnumber;
    }


    /**
	 * 获取：学号
	 */

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }
    /**
	 * 设置：用户名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：用户名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账号
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：联系电话
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 获取：联系电话
	 */

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 设置：住宿楼栋
	 */
    public String getZhuSuLou() {
        return zhuSuLou;
    }


    /**
	 * 获取：住宿楼栋
	 */

    public void setZhuSuLou(String zhuSuLou) {
        this.zhuSuLou = zhuSuLou;
    }
    /**
	 * 设置：寝室号
	 */
    public String getDormitory() {
        return dormitory;
    }


    /**
	 * 获取：寝室号
	 */

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }
    /**
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Yonghu{" +
            "id=" + id +
            ", studentnumber=" + studentnumber +
            ", name=" + name +
            ", username=" + username +
            ", password=" + password +
            ", sexTypes=" + sexTypes +
            ", imgPhoto=" + imgPhoto +
            ", phone=" + phone +
            ", zhuSuLou=" + zhuSuLou +
            ", dormitory=" + dormitory +
            ", role=" + role +
        "}";
    }
}
