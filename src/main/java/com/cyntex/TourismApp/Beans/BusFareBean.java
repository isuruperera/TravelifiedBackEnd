package com.cyntex.TourismApp.Beans;

public class BusFareBean {

    private final String category;
    private final double fare;

    public BusFareBean(String category, double fare) {
        this.category = category;
        this.fare = fare;
    }

    public String getCategory() {
        return category;
    }


    public double getFare() {
        return fare;
    }

}
