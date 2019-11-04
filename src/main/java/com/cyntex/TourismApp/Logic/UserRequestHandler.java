package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRequestHandler {

    @Autowired
    private UserDAO userDAO;

    public BaseResponse handle(ProfileRequestBean profileRequestBean) {
        ProfileResponseBean responseBean = new ProfileResponseBean();
        try {
            List<RatingsProfileQueryResponseBean> queryResponse =
                    userDAO.getUserRatingsProfile(profileRequestBean.getUsername());
            Map<String, List<Double>> userRatingsTotals = new HashMap<>();
            for (RatingsProfileQueryResponseBean queryResponseBean : queryResponse) {
                List<Double> ratingValue = userRatingsTotals.get(queryResponseBean.getCategory());
                if (ratingValue == null) {
                    ratingValue = new ArrayList<>();
                    ratingValue.add(queryResponseBean.getRating());
                    userRatingsTotals.put(queryResponseBean.getCategory(), ratingValue);
                } else {
                    ratingValue.add(queryResponseBean.getRating());
                }
            }
            responseBean.setUserRatings(new ArrayList<>());
            for (String category : userRatingsTotals.keySet()) {
                double totalRating = userRatingsTotals.get(category)
                                                      .stream()
                                                      .mapToDouble(x -> x).sum();
                double averageRating =
                        Math.round((((double) totalRating / userRatingsTotals.get(category).size())) * 100.0) / 100.0;
                responseBean.getUserRatings().add(new UserRating(category, averageRating));
            }
            List<UserBean> users = userDAO.getUserProfile(profileRequestBean.getUsername());
            responseBean.setUser(users.get(0));
            responseBean.setStatus("SUCCESS");
        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handle(AddUserRatingBean userRatingBean) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            userDAO.setAddUserRating(userRatingBean.getRatingUserId(),
                                     userRatingBean.getUserId(),
                                     userRatingBean.getAdventurer(),
                                     userRatingBean.getEntertainer(),
                                     userRatingBean.getFriendInNeed(),
                                     userRatingBean.getMasterChef(),
                                     userRatingBean.getAnimalLover());
            baseResponse.setStatus("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return baseResponse;
    }
}
