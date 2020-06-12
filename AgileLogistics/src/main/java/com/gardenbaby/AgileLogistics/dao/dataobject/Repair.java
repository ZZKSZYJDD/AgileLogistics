package com.gardenbaby.AgileLogistics.dao.dataobject;

import java.util.Date;

/**
 * 
 * @date 2020/06/12
 */
public class Repair {
    private Integer id;

    /**
     * 维修人ID
     */
    private Integer repairmanid;

    /**
     * 申请单ID
     */
    private Integer applyid;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 分派时间
     */
    private Date assigntime;

    /**
     * 完成时间
     */
    private Date completetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairmanid() {
        return repairmanid;
    }

    public void setRepairmanid(Integer repairmanid) {
        this.repairmanid = repairmanid;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getAssigntime() {
        return assigntime;
    }

    public void setAssigntime(Date assigntime) {
        this.assigntime = assigntime;
    }

    public Date getCompletetime() {
        return completetime;
    }

    public void setCompletetime(Date completetime) {
        this.completetime = completetime;
    }
}