package com.entity.model;

import com.entity.JiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 快递接单表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-11
 */
public class JiedanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 单号
     */
    private String odd;


    /**
     * 快递名称
     */
    private Integer daiqukuaidiId;


    /**
     * 发布人
     */
    private Integer jdyonghuId;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date initiateTime;


    /**
     * 收件人名称
     */
    private String addresseename;


    /**
     * 电话
     */
    private String jdphone;


    /**
     * 地址
     */
    private String jdaddressee;


    /**
     * (取/寄)件码
     */
    private String jdtakecode;


    /**
     * 快递状态
     */
    private Integer jdztTypes;


    /**
     * 快递类型
     */
    private Integer kdlxTypes;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：单号
	 */
    public String getOdd() {
        return odd;
    }


    /**
	 * 设置：单号
	 */
    public void setOdd(String odd) {
        this.odd = odd;
    }
    /**
	 * 获取：快递名称
	 */
    public Integer getDaiqukuaidiId() {
        return daiqukuaidiId;
    }


    /**
	 * 设置：快递名称
	 */
    public void setDaiqukuaidiId(Integer daiqukuaidiId) {
        this.daiqukuaidiId = daiqukuaidiId;
    }
    /**
	 * 获取：发布人
	 */
    public Integer getJdyonghuId() {
        return jdyonghuId;
    }


    /**
	 * 设置：发布人
	 */
    public void setJdyonghuId(Integer jdyonghuId) {
        this.jdyonghuId = jdyonghuId;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInitiateTime() {
        return initiateTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }
    /**
	 * 获取：收件人名称
	 */
    public String getAddresseename() {
        return addresseename;
    }


    /**
	 * 设置：收件人名称
	 */
    public void setAddresseename(String addresseename) {
        this.addresseename = addresseename;
    }
    /**
	 * 获取：电话
	 */
    public String getJdphone() {
        return jdphone;
    }


    /**
	 * 设置：电话
	 */
    public void setJdphone(String jdphone) {
        this.jdphone = jdphone;
    }
    /**
	 * 获取：地址
	 */
    public String getJdaddressee() {
        return jdaddressee;
    }


    /**
	 * 设置：地址
	 */
    public void setJdaddressee(String jdaddressee) {
        this.jdaddressee = jdaddressee;
    }
    /**
	 * 获取：(取/寄)件码
	 */
    public String getJdtakecode() {
        return jdtakecode;
    }


    /**
	 * 设置：(取/寄)件码
	 */
    public void setJdtakecode(String jdtakecode) {
        this.jdtakecode = jdtakecode;
    }
    /**
	 * 获取：快递状态
	 */
    public Integer getJdztTypes() {
        return jdztTypes;
    }


    /**
	 * 设置：快递状态
	 */
    public void setJdztTypes(Integer jdztTypes) {
        this.jdztTypes = jdztTypes;
    }
    /**
	 * 获取：快递类型
	 */
    public Integer getKdlxTypes() {
        return kdlxTypes;
    }


    /**
	 * 设置：快递类型
	 */
    public void setKdlxTypes(Integer kdlxTypes) {
        this.kdlxTypes = kdlxTypes;
    }

    }
