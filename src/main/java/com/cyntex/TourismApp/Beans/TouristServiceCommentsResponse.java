package com.cyntex.TourismApp.Beans;

import java.util.List;

public class TouristServiceCommentsResponse extends BaseResponse {
    private List<ServiceRatingCommentBean> comments;

    private double avgRating;

    public List<ServiceRatingCommentBean> getComments() {
        return comments;
    }

    public void setComments(List<ServiceRatingCommentBean> comments) {
        this.comments = comments;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
