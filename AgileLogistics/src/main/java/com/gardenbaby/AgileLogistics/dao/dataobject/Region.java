package com.gardenbaby.AgileLogistics.dao.dataobject;

/**
 * 
 * @date 2020/06/08
 */
public class Region {
    private Integer id;
    /**
     * 区域楼栋
     */
    private String building;
    /**
     * 区域楼层
     */
    private String floor;

    public Region(Integer id, String building, String floor) {
        this.id = id;
        this.building = building;
        this.floor = floor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}