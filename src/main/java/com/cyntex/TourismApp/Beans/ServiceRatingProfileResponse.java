package com.cyntex.TourismApp.Beans;

import java.util.List;

public class ServiceRatingProfileResponse {
    private List<ServiceRatingProfileBean> ratings;
    private double averageRating;

    public List<ServiceRatingProfileBean> getRatings() {
        return ratings;
    }

    public void setRatings(List<ServiceRatingProfileBean> ratings) {
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
