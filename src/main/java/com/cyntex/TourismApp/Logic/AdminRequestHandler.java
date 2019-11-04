package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.AdminDAO;
import com.cyntex.TourismApp.Util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRequestHandler {

    @Autowired
    private AdminDAO adminDAO;

    public BaseResponse handleGetAllUsers(AdminRequestBean requestBean) {
        AdminUserListResponse responseBean = new AdminUserListResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                List<AdminUserListBean> users = adminDAO.getAllUsers();
                responseBean.setList(users);
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }

        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handleUpdateUser(AdminRequestBean requestBean) {
        BaseResponse responseBean = new BaseResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                adminDAO.updateUser(requestBean.getUpdateID(), requestBean.getUpdateValue());
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }

        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handleGetAllEvents(AdminRequestBean requestBean) {
        AdminEventListResponse responseBean = new AdminEventListResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                List<AdminEventBean> list = adminDAO.getAllEvents();
                responseBean.setList(list);
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }

        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handleUpdateEvent(AdminRequestBean requestBean) {
        BaseResponse responseBean = new BaseResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                adminDAO.updateEvent(requestBean.getUpdateID(), requestBean.getUpdateValue());
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }

        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handleGetAllServices(AdminRequestBean requestBean) {
        AdminServiceListResponse responseBean = new AdminServiceListResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                List<AdminServiceBean> list = adminDAO.getAllServices();
                responseBean.setList(list);
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }
        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }

    public BaseResponse handleUpdateService(AdminRequestBean requestBean) {
        BaseResponse responseBean = new BaseResponse();
        try {
            if (validateAdmin(requestBean.getAdminToken(), requestBean.getId())) {
                adminDAO.updateService(requestBean.getUpdateID(), requestBean.getUpdateValue());
                responseBean.setStatus("SUCCESS");
            } else {
                responseBean.setStatus("FAIL");
            }

        } catch (Exception e) {
            responseBean.setStatus("FAIL");
        }

        return responseBean;
    }


    private boolean validateAdmin(String adminToken, String id) {
        return adminToken.equals(PasswordEncrypter.getsha256Securepassword(
                id,
                PasswordEncrypter.SERVER_ADMIN_KEY.getBytes()));
    }
}
