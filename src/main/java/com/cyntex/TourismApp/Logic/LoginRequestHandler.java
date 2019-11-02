package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.UserDAO;
import com.cyntex.TourismApp.Util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class LoginRequestHandler {

    @Autowired
    private UserDAO userDAO;

    public BaseResponse handle(LoginRequestBean requestBean) {
        RegistrationResponseBean response = new RegistrationResponseBean();
        try {
            List<AuthenticatedUserBean> userList = userDAO.getAuthenticatedUser(requestBean.getEmail());
            if (userList.size() > 0) {
                AuthenticatedUserBean authenticatedUserBean = userList.get(0);
                String generatedPwd = PasswordEncrypter.getsha256Securepassword(requestBean.getPassword(),
                                                                                authenticatedUserBean.getPwdSalt().getBytes());
                if (generatedPwd.equals(authenticatedUserBean.getPassword())) {
                    String id = UUID.randomUUID().toString();
                    if (authenticatedUserBean.getIsAdmin() == 1) {
                        AdminRegistrationResponseBean adminRegistrationResponseBean = new AdminRegistrationResponseBean();
                        adminRegistrationResponseBean.setAdminToken(PasswordEncrypter.getsha256Securepassword(
                                id,
                                PasswordEncrypter.SERVER_ADMIN_KEY.getBytes()));
                        response = adminRegistrationResponseBean;
                    }
                    response.setStatus("SUCCESS");
                    response.setProfilePicID(authenticatedUserBean.getImageID());
                    response.setId(id);
                    response.setToken(PasswordEncrypter.getsha256Securepassword(
                            id,
                            PasswordEncrypter.SERVER_KEY.getBytes()
                    ));
                } else {
                    response.setStatus("FAILED: Password is incorrect!");
                }
            } else {
                response.setStatus("FAILED: User not found!");
            }
        } catch (Exception e) {
            response.setStatus("FAILED: Cannot login with this user");
        }
        return response;
    }
}
