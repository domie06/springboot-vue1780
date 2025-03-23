package com.entity.model;

import com.entity.DaiqurenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-11
 */
public class DaiqurenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


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


    /**
	 * 获取：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：id
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 设置：用户名称
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 获取：账号
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账号
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 获取：联系电话
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 设置：联系电话
	 */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 获取：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 设置：身份
	 */
    public void setRole(String role) {
        this.role = role;
    }

    }
