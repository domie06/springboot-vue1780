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
 * 快递站点
 *
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("zhandian")
public class ZhandianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhandianEntity() {

	}

	public ZhandianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 站点名称
     */
    @TableField(value = "zdname")

    private String zdname;


    /**
     * 站点地址
     */
    @TableField(value = "address")

    private String address;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：站点名称
	 */
    public String getZdname() {
        return zdname;
    }


    /**
	 * 获取：站点名称
	 */

    public void setZdname(String zdname) {
        this.zdname = zdname;
    }
    /**
	 * 设置：站点地址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 获取：站点地址
	 */

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Zhandian{" +
            "id=" + id +
            ", zdname=" + zdname +
            ", address=" + address +
        "}";
    }
}
