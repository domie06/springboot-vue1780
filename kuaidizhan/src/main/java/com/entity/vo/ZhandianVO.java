package com.entity.vo;

import com.entity.ZhandianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 快递站点
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-11
 */
@TableName("zhandian")
public class ZhandianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
