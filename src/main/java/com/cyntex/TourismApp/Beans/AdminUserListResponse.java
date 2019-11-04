package com.cyntex.TourismApp.Beans;

import java.util.List;

public class AdminUserListResponse extends BaseResponse {

    private List<AdminUserListBean> list;


    public List<AdminUserListBean> getList() {
        return list;
    }

    public void setList(List<AdminUserListBean> list) {
        this.list = list;
    }
}
