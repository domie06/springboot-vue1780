package com.entity.vo;

import com.entity.DaiquEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 待取件表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("daiqu")
public class DaiquVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 快递名称
     */

    @TableField(value = "dqname")
    private String dqname;


    /**
     * 站点
     */

    @TableField(value = "zhandian_id")
    private Integer zhandianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 快递大小
     */

    @TableField(value = "kddx_types")
    private Integer kddxTypes;


    /**
     * 手机号
     */

    @TableField(value = "dqphone")
    private Integer dqphone;


    /**
     * 取件码
     */

    @TableField(value = "takecode")
    private String takecode;


    /**
     * 快递状态
     */

    @TableField(value = "kdzt_types")
    private Integer kdztTypes;


    /**
     * 取件时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pickup_time")
    private Date pickupTime;


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
	 * 设置：快递名称
	 */
    public String getDqname() {
        return dqname;
    }


    /**
	 * 获取：快递名称
	 */

    public void setDqname(String dqname) {
        this.dqname = dqname;
    }
    /**
	 * 设置：站点
	 */
    public Integer getZhandianId() {
        return zhandianId;
    }


    /**
	 * 获取：站点
	 */

    public void setZhandianId(Integer zhandianId) {
        this.zhandianId = zhandianId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：快递大小
	 */
    public Integer getKddxTypes() {
        return kddxTypes;
    }


    /**
	 * 获取：快递大小
	 */

    public void setKddxTypes(Integer kddxTypes) {
        this.kddxTypes = kddxTypes;
    }
    /**
	 * 设置：手机号
	 */
    public Integer getDqphone() {
        return dqphone;
    }


    /**
	 * 获取：手机号
	 */

    public void setDqphone(Integer dqphone) {
        this.dqphone = dqphone;
    }
    /**
	 * 设置：取件码
	 */
    public String getTakecode() {
        return takecode;
    }


    /**
	 * 获取：取件码
	 */

    public void setTakecode(String takecode) {
        this.takecode = takecode;
    }
    /**
	 * 设置：快递状态
	 */
    public Integer getKdztTypes() {
        return kdztTypes;
    }


    /**
	 * 获取：快递状态
	 */

    public void setKdztTypes(Integer kdztTypes) {
        this.kdztTypes = kdztTypes;
    }
    /**
	 * 设置：取件时间
	 */
    public Date getPickupTime() {
        return pickupTime;
    }


    /**
	 * 获取：取件时间
	 */

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

}
