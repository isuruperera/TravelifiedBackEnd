package com.cyntex.TourismApp.Beans;

import java.util.List;

public class AdminServiceListResponse extends BaseResponse {

    private List<AdminServiceBean> list;


    public List<AdminServiceBean> getList() {
        return list;
    }

    public void setList(List<AdminServiceBean> list) {
        this.list = list;
    }
}
