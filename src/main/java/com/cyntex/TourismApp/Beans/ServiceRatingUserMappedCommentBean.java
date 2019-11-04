package com.cyntex.TourismApp.Beans;

public class ServiceRatingUserMappedCommentBean extends ServiceRatingCommentBean {

    private String userPictureID;

    private String userFullName;

    private String country;

    public ServiceRatingUserMappedCommentBean(String userId, int serviceId, String photo, String comment, double rating) {
        super(userId, serviceId, photo, comment, rating);
    }

    public String getUserPictureID() {
        return userPictureID;
    }

    public void setUserPictureID(String userPictureID) {
        this.userPictureID = userPictureID;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
