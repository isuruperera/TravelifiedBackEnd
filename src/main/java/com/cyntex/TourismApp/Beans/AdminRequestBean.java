package com.cyntex.TourismApp.Beans;

public class AdminRequestBean {

    private String adminToken;
    private String id;
    private String username;

    private String updateID;
    private int updateValue;

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateID() {
        return updateID;
    }

    public void setUpdateID(String updateID) {
        this.updateID = updateID;
    }

    public int getUpdateValue() {
        return updateValue;
    }

    public void setUpdateValue(int updateValue) {
        this.updateValue = updateValue;
    }
}
