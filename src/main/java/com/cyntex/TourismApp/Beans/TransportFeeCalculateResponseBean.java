package com.cyntex.TourismApp.Beans;

public class TransportFeeCalculateResponseBean extends BaseResponse {
    private double fareEstimation;

    public double getFareEstimation() {
        return fareEstimation;
    }

    public void setFareEstimation(double fareEstimation) {
        this.fareEstimation = fareEstimation;
    }
}
