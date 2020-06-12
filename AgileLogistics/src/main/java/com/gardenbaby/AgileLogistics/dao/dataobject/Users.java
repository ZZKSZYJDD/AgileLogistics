package com.gardenbaby.AgileLogistics.dao.dataobject;

/**
 * 
 * @date 2020/06/01
 */
public class Users {
    private Integer id;

    private String username;

    private String pwd;

    private Integer power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Users(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public Users() {

    }

    public Users(Integer id, String username, String pwd, Integer power) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.power = power;
    }
}