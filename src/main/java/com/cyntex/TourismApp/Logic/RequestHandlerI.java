package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.BaseRequest;
import com.cyntex.TourismApp.Beans.BaseResponse;

public interface RequestHandlerI {
    public BaseResponse handle(BaseRequest baseRequest);
}
