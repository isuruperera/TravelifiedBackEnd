package com.cyntex.TourismApp.Beans;

import java.util.List;

public class TransportFeeCalculateRequestBean {
    private List<BusFareRequestBean> request;

    public List<BusFareRequestBean> getRequest() {
        return request;
    }

    public void setRequest(List<BusFareRequestBean> request) {
        this.request = request;
    }
}
