package com.cyntex.TourismApp.Beans;

import java.util.List;

public class BusInformationResponseBean extends BaseResponse {

    private List<BusFareBean> busFares;

    public List<BusFareBean> getBusFares() {
        return busFares;
    }

    public void setBusFares(List<BusFareBean> busFares) {
        this.busFares = busFares;
    }
}
