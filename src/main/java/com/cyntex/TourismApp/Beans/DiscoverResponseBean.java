package com.cyntex.TourismApp.Beans;

import java.util.List;

public class DiscoverResponseBean extends BaseResponse {
    private List<AttaractionSummary> attaractions;

    public List<AttaractionSummary> getAttaractions() {
        return attaractions;
    }

    public void setAttaractions(List<AttaractionSummary> attaractions) {
        this.attaractions = attaractions;
    }
}
