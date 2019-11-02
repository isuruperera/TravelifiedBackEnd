package com.cyntex.TourismApp.Beans;

import java.util.List;

public class ProfileResponseBean extends BaseResponse {

    private UserBean user;

    private List<UserRating> userRatings;

    public List<UserRating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<UserRating> userRatings) {
        this.userRatings = userRatings;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
