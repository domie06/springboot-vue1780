package com.entity.model;

import com.entity.DaiquEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 待取件表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-11
 */
public class DaiquModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 快递名称
     */
    private String dqname;


    /**
     * 站点
     */
    private Integer zhandianId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 快递大小
     */
    private Integer kddxTypes;


    /**
     * 手机号
     */
    private Integer dqphone;


    /**
     * 取件码
     */
    private String takecode;


    /**
     * 快递状态
     */
    private Integer kdztTypes;


    /**
     * 取件时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pickupTime;


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
	 * 获取：快递名称
	 */
    public String getDqname() {
        return dqname;
    }


    /**
	 * 设置：快递名称
	 */
    public void setDqname(String dqname) {
        this.dqname = dqname;
    }
    /**
	 * 获取：站点
	 */
    public Integer getZhandianId() {
        return zhandianId;
    }


    /**
	 * 设置：站点
	 */
    public void setZhandianId(Integer zhandianId) {
        this.zhandianId = zhandianId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：快递大小
	 */
    public Integer getKddxTypes() {
        return kddxTypes;
    }


    /**
	 * 设置：快递大小
	 */
    public void setKddxTypes(Integer kddxTypes) {
        this.kddxTypes = kddxTypes;
    }
    /**
	 * 获取：手机号
	 */
    public Integer getDqphone() {
        return dqphone;
    }


    /**
	 * 设置：手机号
	 */
    public void setDqphone(Integer dqphone) {
        this.dqphone = dqphone;
    }
    /**
	 * 获取：取件码
	 */
    public String getTakecode() {
        return takecode;
    }


    /**
	 * 设置：取件码
	 */
    public void setTakecode(String takecode) {
        this.takecode = takecode;
    }
    /**
	 * 获取：快递状态
	 */
    public Integer getKdztTypes() {
        return kdztTypes;
    }


    /**
	 * 设置：快递状态
	 */
    public void setKdztTypes(Integer kdztTypes) {
        this.kdztTypes = kdztTypes;
    }
    /**
	 * 获取：取件时间
	 */
    public Date getPickupTime() {
        return pickupTime;
    }


    /**
	 * 设置：取件时间
	 */
    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    }
