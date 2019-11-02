package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.RegistrationRequestBean;
import com.cyntex.TourismApp.Beans.RegistrationResponseBean;
import com.cyntex.TourismApp.Persistance.RegistrationDAO;
import com.cyntex.TourismApp.Util.FSManager;
import com.cyntex.TourismApp.Util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationRequestHandler {

    @Autowired
    private RegistrationDAO registrationDAO;

    public BaseResponse handle(RegistrationRequestBean requestBean){
        RegistrationResponseBean response = new RegistrationResponseBean();
        try{ 
            String imageID = UUID.randomUUID().toString();
            String pwdSalt = UUID.randomUUID().toString().substring(0, 8);
            String locationID = UUID.randomUUID().toString();
            FSManager.saveImage(imageID, requestBean.getImage());
            registrationDAO.addNewUser(
                    requestBean.getEmail(),
                    requestBean.getFirstName(),
                    requestBean.getLastName(),
                    requestBean.getGender(),
                    requestBean.getCountry(),

                    requestBean.getPhone(),
                    imageID,
                    locationID,
                    pwdSalt,
                    PasswordEncrypter.getsha256Securepassword(requestBean.getPassword(), pwdSalt.getBytes())
            );

            response.setStatus("SUCCESS");
            String id = UUID.randomUUID().toString();
            response.setId(id);
            response.setProfilePicID(imageID);
            response.setToken(PasswordEncrypter.getsha256Securepassword(
                    id,
                    PasswordEncrypter.SERVER_KEY.getBytes()
            ));
        }catch (Exception e) {
            response.setStatus("FAILED: Cannot register this user");
        }
        return response;
    }
}
