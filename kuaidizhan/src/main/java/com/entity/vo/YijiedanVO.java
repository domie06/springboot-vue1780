package com.entity.vo;

import com.entity.YijiedanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 已接单表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("yijiedan")
public class YijiedanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "initiate_time")
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

}
