package com.cyntex.TourismApp.Services;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.LoginRequestBean;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Logic.LoginRequestHandler;
import com.cyntex.TourismApp.Logic.RegistrationRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private RegistrationRequestHandler registrationRequestHandler;

    @Autowired
    private LoginRequestHandler loginRequestHandler;

    public BaseResponse requestRegistration(RegistrationRequestBean requestBean){
        return registrationRequestHandler.handle(requestBean);
    }

    public BaseResponse loginUser(LoginRequestBean requestBean) {
        return loginRequestHandler.handle(requestBean);
    }
}
