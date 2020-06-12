package com.gardenbaby.AgileLogistics.dao.dataobject;

import java.util.Date;

/**
 * 
 * @date 2020/06/12
 */
public class Apply {
    private Integer id;

    /**
     * 报修单号
     */
    private String applyorderid;

    /**
     * 报修人ID
     */
    private Integer applymanid;

    /**
     * 区域ID
     */
    private Integer applyregionid;

    /**
     * 描述
     */
    private String applydescribe;

    /**
     * 图片地址
     */
    private String pictureurl;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 申请时间
     */
    private Date applytime;

    /**
     * 申请备注
     */
    private String applyremarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyorderid() {
        return applyorderid;
    }

    public void setApplyorderid(String applyorderid) {
        this.applyorderid = applyorderid;
    }

    public Integer getApplymanid() {
        return applymanid;
    }

    public void setApplymanid(Integer applymanid) {
        this.applymanid = applymanid;
    }

    public Integer getApplyregionid() {
        return applyregionid;
    }

    public void setApplyregionid(Integer applyregionid) {
        this.applyregionid = applyregionid;
    }

    public String getApplydescribe() {
        return applydescribe;
    }

    public void setApplydescribe(String applydescribe) {
        this.applydescribe = applydescribe;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getApplyremarks() {
        return applyremarks;
    }

    public void setApplyremarks(String applyremarks) {
        this.applyremarks = applyremarks;
    }
}