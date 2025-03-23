package com.entity.model;

import com.entity.ZhandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 快递站点
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-11
 */
public class ZhandianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 站点名称
     */
    private String zdname;


    /**
     * 站点地址
     */
    private String address;


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
	 * 获取：站点名称
	 */
    public String getZdname() {
        return zdname;
    }


    /**
	 * 设置：站点名称
	 */
    public void setZdname(String zdname) {
        this.zdname = zdname;
    }
    /**
	 * 获取：站点地址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 设置：站点地址
	 */
    public void setAddress(String address) {
        this.address = address;
    }

    }
