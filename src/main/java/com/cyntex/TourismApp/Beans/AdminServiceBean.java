package com.cyntex.TourismApp.Beans;

public class AdminServiceBean {

    private String serviceId;
    private String serviceName;
    private String imageID;
    private int serviceStatus;


    public AdminServiceBean(String serviceId, String serviceName, String imageID, int serviceStatus) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.setImageID(imageID);
        this.setServiceStatus(serviceStatus);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
