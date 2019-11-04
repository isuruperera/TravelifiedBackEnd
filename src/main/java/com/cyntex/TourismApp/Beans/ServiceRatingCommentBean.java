package com.cyntex.TourismApp.Beans;

public class ServiceRatingCommentBean {
    private double rating;
    private String comment;
    private String photo;
    private int serviceId;
    private String userId;

    public ServiceRatingCommentBean(String userId, int serviceId, String photo, String comment, double rating) {
        this.userId = userId;
        this.serviceId = serviceId;
        this.photo = photo;
        this.comment = comment;
        this.rating = rating;
    }

    public ServiceRatingCommentBean() {

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
