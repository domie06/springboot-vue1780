package com.entity.vo;

import com.entity.DaiqurenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("daiquren")
public class DaiqurenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


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

}
