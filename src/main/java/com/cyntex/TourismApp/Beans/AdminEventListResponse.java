package com.cyntex.TourismApp.Beans;

import java.util.List;

public class AdminEventListResponse extends BaseResponse {

    private List<AdminEventBean> list;


    public List<AdminEventBean> getList() {
        return list;
    }

    public void setList(List<AdminEventBean> list) {
        this.list = list;
    }
}
