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
 * 快递接单表
 *
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("jiedan")
public class JiedanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiedanEntity() {

	}

	public JiedanEntity(T t) {
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
     * 单号
     */
    @TableField(value = "dx")

    private Integer dx;


    /**
     * 快递名称
     */
    @TableField(value = "daiqukuaidimc")
    private String daiqukuaidimc;

    public String getDaiqukuaidimc() {
        return daiqukuaidimc;
    }

    public void setDaiqukuaidimc(String daiqukuaidimc) {
        this.daiqukuaidimc = daiqukuaidimc;
    }

    /**
     * 发布人
     */
    @TableField(value = "jdyonghu_id")

    private Integer jdyonghuId;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "initiate_time",fill = FieldFill.UPDATE)

    private Date initiateTime;


    /**
     * 收件人名称
     */
    @TableField(value = "addresseename")

    private String addresseename;


    /**
     * 电话
     */
    @TableField(value = "jdphone")

    private String jdphone;


    /**
     * 地址
     */
    @TableField(value = "jdaddressee")

    private String jdaddressee;


    /**
     * (取/寄)件码
     */
    @TableField(value = "jdtakecode")

    private String jdtakecode;


    /**
     * 快递状态
     */
    @TableField(value = "jdzt_types")

    private Integer jdztTypes;

    /**
     * 快递类型
     */
    @TableField(value = "kdlx_types")

    private Integer kdlxTypes;


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
    public Integer getJdyonghuId() {
        return jdyonghuId;
    }


    /**
	 * 获取：发布人
	 */

    public void setJdyonghuId(Integer jdyonghuId) {
        this.jdyonghuId = jdyonghuId;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInitiateTime() {
        return initiateTime;
    }



    /**
	 * 获取：发布时间
	 */

    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }
    /**
	 * 设置：收件人名称
	 */
    public String getAddresseename() {
        return addresseename;
    }


    /**
	 * 获取：收件人名称
	 */

    public void setAddresseename(String addresseename) {
        this.addresseename = addresseename;
    }
    /**
	 * 设置：电话
	 */
    public String getJdphone() {
        return jdphone;
    }


    /**
	 * 获取：电话
	 */

    public void setJdphone(String jdphone) {
        this.jdphone = jdphone;
    }
    /**
	 * 设置：地址
	 */
    public String getJdaddressee() {
        return jdaddressee;
    }


    /**
	 * 获取：地址
	 */

    public void setJdaddressee(String jdaddressee) {
        this.jdaddressee = jdaddressee;
    }
    /**
	 * 设置：(取/寄)件码
	 */
    public String getJdtakecode() {
        return jdtakecode;
    }


    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    /**
	 * 获取：(取/寄)件码
	 */

    public void setJdtakecode(String jdtakecode) {
        this.jdtakecode = jdtakecode;
    }
    /**
	 * 设置：快递状态
	 */
    public Integer getJdztTypes() {
        return jdztTypes;
    }


    /**
	 * 获取：快递状态
	 */

    public void setJdztTypes(Integer jdztTypes) {
        this.jdztTypes = jdztTypes;
    }
    /**
	 * 设置：快递类型
	 */
    public Integer getKdlxTypes() {
        return kdlxTypes;
    }


    /**
	 * 获取：快递类型
	 */

    public void setKdlxTypes(Integer kdlxTypes) {
        this.kdlxTypes = kdlxTypes;
    }

    @Override
    public String toString() {
        return "Jiedan{" +
            "id=" + id +
            ", odd=" + odd +
            ", daiqukuaidimc=" + daiqukuaidimc +
            ", jdyonghuId=" + jdyonghuId +
            ", initiateTime=" + initiateTime +
            ", addresseename=" + addresseename +
            ", jdphone=" + jdphone +
            ", jdaddressee=" + jdaddressee +
            ", jdtakecode=" + jdtakecode +
            ", jdztTypes=" + jdztTypes +
            ", kdlxTypes=" + kdlxTypes +
        "}";
    }
}
