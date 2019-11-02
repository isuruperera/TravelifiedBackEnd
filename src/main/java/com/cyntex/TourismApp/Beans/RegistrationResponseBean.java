package com.cyntex.TourismApp.Beans;

public class RegistrationResponseBean extends BaseResponse {
    private String token;
    private String id;
    private String profilePicID;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePicID() {
        return profilePicID;
    }

    public void setProfilePicID(String profilePicID) {
        this.profilePicID = profilePicID;
    }
}
