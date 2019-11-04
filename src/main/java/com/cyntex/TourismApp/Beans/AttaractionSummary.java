package com.cyntex.TourismApp.Beans;

public class AttaractionSummary {
    private final int serviceID;
    private final String name;
    private final String description;
    private final LocationBean location;
    private final double fee;
    private double rating;
    private String titlePhoto;

    public AttaractionSummary(int serviceID, String name, String description, LocationBean location, double fee,
                              String titlePhoto) {
        this.serviceID = serviceID;
        this.name = name;
        this.description = description;
        this.location = location;
        this.fee = fee;
        this.titlePhoto = titlePhoto;
    }


    public LocationBean getLocation() {
        return location;
    }

    public double getFee() {
        return fee;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getServiceID() {
        return serviceID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto;
    }
}
