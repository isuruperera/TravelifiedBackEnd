package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.UserRatingsProfileDAO;
import com.cyntex.TourismApp.Util.UserRatingCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RatingProfileRequestHandler {

    @Autowired
    private UserRatingsProfileDAO userRatingsProfileDAO;
    
    @Autowired
    private UserRatingCalculator userRatingcalcalculator;

    public BaseResponse handle(RatingsProfileRequestBean ratingsProfileRequestBean) {
        RatingsProfileResponseBean response = new RatingsProfileResponseBean();
        String username=ratingsProfileRequestBean.getUsername();
        try {
        	if(!StringUtils.isEmpty(username)){
            List<RatingsProfileQueryResponseBean> queryResponse =
                    userRatingsProfileDAO.getUserRatingsProfile(username);
            response=userRatingcalcalculator.RatingProfileResponse(queryResponse);
            response.setStatus("SUCCESS");
        	}else{
        		response.setStatus("FAILED: Check the payload again");
        	}
        } catch (Exception e) {
        	response.setStatus("FAIL");
        }

        return response;
    }
}
