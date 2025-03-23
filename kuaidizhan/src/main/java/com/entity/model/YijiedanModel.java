package com.entity.model;

import com.entity.YijiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 已接单表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-11
 */
public class YijiedanModel implements Serializable {
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
     * 发布人
     */
    private Integer yonghuId;


    /**
     * 手机号
     */
    private String fbphone;


    /**
     * 接单人
     */
    private Integer daiqurenId;


    /**
     * 手机号
     */
    private String jdphone;


    /**
     * 接单时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date initiateTime;


    /**
     * 订单状态
     */
    private Integer ddztTypes;


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
	 * 获取：发布人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：发布人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：手机号
	 */
    public String getFbphone() {
        return fbphone;
    }


    /**
	 * 设置：手机号
	 */
    public void setFbphone(String fbphone) {
        this.fbphone = fbphone;
    }
    /**
	 * 获取：接单人
	 */
    public Integer getDaiqurenId() {
        return daiqurenId;
    }


    /**
	 * 设置：接单人
	 */
    public void setDaiqurenId(Integer daiqurenId) {
        this.daiqurenId = daiqurenId;
    }
    /**
	 * 获取：手机号
	 */
    public String getJdphone() {
        return jdphone;
    }


    /**
	 * 设置：手机号
	 */
    public void setJdphone(String jdphone) {
        this.jdphone = jdphone;
    }
    /**
	 * 获取：接单时间
	 */
    public Date getInitiateTime() {
        return initiateTime;
    }


    /**
	 * 设置：接单时间
	 */
    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }
    /**
	 * 获取：订单状态
	 */
    public Integer getDdztTypes() {
        return ddztTypes;
    }


    /**
	 * 设置：订单状态
	 */
    public void setDdztTypes(Integer ddztTypes) {
        this.ddztTypes = ddztTypes;
    }

    }
