package com.cyntex.TourismApp.Util;

import com.cyntex.TourismApp.Beans.ProfileResponseBean;
import com.cyntex.TourismApp.Beans.RatingsProfileQueryResponseBean;
import com.cyntex.TourismApp.Beans.UserRating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRatingCalculator {

	public ProfileResponseBean RatingProfileResponse(List<RatingsProfileQueryResponseBean> queryResponse) {
		ProfileResponseBean responseBean = new ProfileResponseBean();
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

			
			return responseBean;
	}
			
}
