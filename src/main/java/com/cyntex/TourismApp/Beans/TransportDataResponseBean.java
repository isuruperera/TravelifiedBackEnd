package com.cyntex.TourismApp.Beans;

import java.util.List;

public class TransportDataResponseBean extends BaseResponse {

    private List<String> cities;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
