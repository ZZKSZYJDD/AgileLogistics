package com.gardenbaby.AgileLogistics.dao.dataobject;

import java.util.Date;

/**
 * 
 * @date 2020/06/09
 */
public class Equipment {
    private Integer id;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备类型
     */
    private String type;
    /**
     * 设备负责人
     */
    private int personLiable;
    /**
     * 设备备注
     */
    private String remarks;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getpersonLiable() {
        return personLiable;
    }

    public void setpersonLiable(int personLiable) {
        this.personLiable = personLiable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getupdateTime() {
        return updateTime;
    }

    public void setupdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Equipment(Integer id, String name, String type, int personLiable, String remarks, Date updateTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.personLiable = personLiable;
        this.remarks = remarks;
        this.updateTime = updateTime;
    }
}