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
 * 已接单表
 *
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("yijiedan")
public class YijiedanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YijiedanEntity() {

	}

	public YijiedanEntity(T t) {
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
     * 单号
     */
    @TableField(value = "odd")

    private String odd;


    /**
     * 发布人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 手机号
     */
    @TableField(value = "fbphone")

    private String fbphone;


    /**
     * 接单人
     */
    @TableField(value = "daiquren_id")

    private Integer daiqurenId;


    /**
     * 手机号
     */
    @TableField(value = "jdphone")

    private String jdphone;


    /**
     * 接单时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "initiate_time",fill = FieldFill.UPDATE)

    private Date initiateTime;


    /**
     * 订单状态
     */
    @TableField(value = "ddzt_types")

    private Integer ddztTypes;


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
	 * 设置：单号
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 获取：单号
	 */

    public void setOdd(String odd) {
        this.odd = odd;
    }
    /**
	 * 设置：发布人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：发布人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：手机号
	 */
    public String getFbphone() {
        return fbphone;
    }


    /**
	 * 获取：手机号
	 */

    public void setFbphone(String fbphone) {
        this.fbphone = fbphone;
    }
    /**
	 * 设置：接单人
	 */
    public Integer getDaiqurenId() {
        return daiqurenId;
    }


    /**
	 * 获取：接单人
	 */

    public void setDaiqurenId(Integer daiqurenId) {
        this.daiqurenId = daiqurenId;
    }
    /**
	 * 设置：手机号
	 */
    public String getJdphone() {
        return jdphone;
    }


    /**
	 * 获取：手机号
	 */

    public void setJdphone(String jdphone) {
        this.jdphone = jdphone;
    }
    /**
	 * 设置：接单时间
	 */
    public Date getInitiateTime() {
        return initiateTime;
    }


    /**
	 * 获取：接单时间
	 */

    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }
    /**
	 * 设置：订单状态
	 */
    public Integer getDdztTypes() {
        return ddztTypes;
    }


    /**
	 * 获取：订单状态
	 */

    public void setDdztTypes(Integer ddztTypes) {
        this.ddztTypes = ddztTypes;
    }

    @Override
    public String toString() {
        return "Yijiedan{" +
            "id=" + id +
            ", odd=" + odd +
            ", yonghuId=" + yonghuId +
            ", fbphone=" + fbphone +
            ", daiqurenId=" + daiqurenId +
            ", jdphone=" + jdphone +
            ", initiateTime=" + initiateTime +
            ", ddztTypes=" + ddztTypes +
        "}";
    }
}
