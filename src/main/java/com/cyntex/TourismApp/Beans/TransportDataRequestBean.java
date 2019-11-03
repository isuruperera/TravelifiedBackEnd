package com.cyntex.TourismApp.Beans;

public class TransportDataRequestBean {

    public static int RT_FROM_CITY = 1;
    public static int RT_TO_CITY = 2;


    private int requestType;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }
}
