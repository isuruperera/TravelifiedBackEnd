package com.cyntex.TourismApp.Beans;

public class AdminRegistrationResponseBean extends RegistrationResponseBean {
    private String adminToken;

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }
}
