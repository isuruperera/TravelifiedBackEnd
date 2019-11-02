package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.RatingsProfileRequestBean;
import com.cyntex.TourismApp.Logic.RatingProfileRequestHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingProfileRequestService {

    @Autowired
    private RatingProfileRequestHandler ratingProfileRequestHandler;

    public BaseResponse getRatingProfile(RatingsProfileRequestBean requestBean) {
        return ratingProfileRequestHandler.handle(requestBean);
    }
}
