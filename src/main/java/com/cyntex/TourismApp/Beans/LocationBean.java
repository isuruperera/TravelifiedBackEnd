package com.cyntex.TourismApp.Beans;

public class LocationBean extends BaseResponse {
    private final double longitude;
    private final double latitude;

    public LocationBean(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

}
