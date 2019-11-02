package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ProfileRequestBean;
import com.cyntex.TourismApp.Logic.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingProfileRequestService {

    @Autowired
    private UserRequestHandler userRequestHandler;

    public BaseResponse getRatingProfile(ProfileRequestBean requestBean) {
        return userRequestHandler.handle(requestBean);
    }
}
