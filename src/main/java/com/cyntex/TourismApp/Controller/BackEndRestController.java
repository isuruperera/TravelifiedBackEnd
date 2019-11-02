package com.cyntex.TourismApp.Controller;


import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import com.cyntex.TourismApp.Logic.TestRequestHandler;
import com.cyntex.TourismApp.Logic.TransportDataRequestHandler;
import com.cyntex.TourismApp.Logic.UserRequestHandler;
import com.cyntex.TourismApp.Services.AuthService;
import com.cyntex.TourismApp.Util.FSManager;
import com.cyntex.TourismApp.Util.JSONHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping(value="/api")
public class BackEndRestController {

    @Autowired
    private AuthService authService;

    @Autowired
    private FoodRequestHandler foodRequestHandler;

    @Autowired
    private UserRequestHandler userRequestHandler;

    @Autowired
    private TestRequestHandler testRequestHandler;

    @Autowired
    private TransportDataRequestHandler transportDataRequestHandler;


    @CrossOrigin()
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String registerUser(@RequestBody String data) throws Exception {
        try {
            RegistrationRequestBean registrationRequestBean = JSONHandler.parseFromJSON(data, RegistrationRequestBean.class);
            BaseResponse response = authService.requestRegistration(registrationRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody String data) throws Exception {
        try {
            LoginRequestBean loginRequestBean = JSONHandler.parseFromJSON(data, LoginRequestBean.class);
            BaseResponse response = authService.loginUser(loginRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/summary", method = RequestMethod.POST)
    public String attaractionDataSummary(@RequestBody String data) throws Exception {
        try {
            DiscoverRequestBean discoverRequestBean = JSONHandler.parseFromJSON(data, DiscoverRequestBean.class);
            BaseResponse response = transportDataRequestHandler.handle(discoverRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/transport", method = RequestMethod.POST)
    public String transportData(@RequestBody String data) throws Exception {
        try {
            TransportDataRequestBean transportDataRequestBean = JSONHandler.parseFromJSON(data, TransportDataRequestBean.class);
            BaseResponse response = transportDataRequestHandler.handle(transportDataRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/calculateFare", method = RequestMethod.POST)
    public String transportFareCalculate(@RequestBody String data) throws Exception {
        try {
            TransportFeeCalculateRequestBean transportDataRequestBean = JSONHandler.parseFromJSON(data, TransportFeeCalculateRequestBean.class);
            BaseResponse response = transportDataRequestHandler.handle(transportDataRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/busfare", method = RequestMethod.POST)
    public String busFare(@RequestBody String data) throws Exception {
        try {
            BusInformationRequestBean busInformationRequestBean = JSONHandler.parseFromJSON(data, BusInformationRequestBean.class);
            BaseResponse response = transportDataRequestHandler.handle(busInformationRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/location", method = RequestMethod.POST)
    public String location(@RequestBody String data) throws Exception {
        try {
            LocationCoordinateRequestBean locationCoordinateRequestBean = JSONHandler.parseFromJSON(data, LocationCoordinateRequestBean.class);
            BaseResponse response = transportDataRequestHandler.handle(locationCoordinateRequestBean);
            return JSONHandler.parseToJSON(response);
        } catch (Exception e) {
            BaseResponse response = new BaseResponse();
            response.setStatus("FAILED: Invalid Request!");
            e.printStackTrace();
            return JSONHandler.parseToJSON(response);
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public byte[] getImage(@RequestParam("id") String imageID) throws Exception {
        try {
            return FSManager.retrieveImage(imageID);
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin()
    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    public String requestUserProfile(@RequestBody String data) throws Exception {
        ProfileRequestBean shopDetailsRequestBean = JSONHandler.parseFromJSON(data, ProfileRequestBean.class);
        BaseResponse response = userRequestHandler.handle(shopDetailsRequestBean);
        return JSONHandler.parseToJSON(response);
    }

    @CrossOrigin()
    @RequestMapping(value="/auth/user",method= RequestMethod.GET)
    public String version(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @RequestMapping(value="/options",method= RequestMethod.OPTIONS)
    public String options(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value="/auth/admin",method= RequestMethod.GET)
    public String versionAdmin(){
        return "{SUCCESS}";
    }

    @CrossOrigin()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value="/updateData",method= RequestMethod.POST)
    public String updateData(@RequestBody String data) throws Exception {
        return "NOT IMPL";
    }




}
