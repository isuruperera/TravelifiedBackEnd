package com.cyntex.TourismApp.Controller;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Logic.FoodRequestHandler;
import com.cyntex.TourismApp.Logic.TestRequestHandler;
import com.cyntex.TourismApp.Logic.TransportDataRequestHandler;
import com.cyntex.TourismApp.Logic.UserRequestHandler;
import com.cyntex.TourismApp.Services.*;
import com.cyntex.TourismApp.Util.FSManager;
import com.cyntex.TourismApp.Util.JSONHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private TransportDataRequestHandler transportDataRequestHandler;

    @Autowired
    private TestRequestHandler testRequestHandler;

    @Autowired
    private TouristFriendService touristFriendService;

    @Autowired
    private ChatGroupService chatGroupService;

    @Autowired
    private UserFriendService userFriendService;

    @Autowired
    private TouristAttractionService touristAttractionService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MakeAdminService makeAdminService;

    @Autowired
    private GroupParticipantService groupParticipantService;

    @Autowired
    private TouristService touristService;


    @RequestMapping(value="/serviceCheck",method= RequestMethod.GET)
    public String serviceCheck() throws Exception{
    	return JSONHandler.parseToJSON("Service is ok");
    }

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

//    @CrossOrigin()
//    @RequestMapping(value="/test/save_text",method= RequestMethod.POST)
//    public String saveTextRequest(@RequestBody String data) throws Exception {
//        TestBean testBean = JSONHandler.parseFromJSON(data, TestBean.class);
//        testRequestHandler.handle(testBean);
//        return "{SUCCESS}";
//    }

    @CrossOrigin()
    @RequestMapping(value="/test/save_text",method= RequestMethod.POST)
    public String saveTextRequest(@RequestBody String data) throws Exception {
        TestBean testBean = JSONHandler.parseFromJSON(data, TestBean.class);
        testRequestHandler.handle(testBean);
        return "{SUCCESS}";
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
    @CrossOrigin()
    @RequestMapping(value="/discoverTouristFriends", method= RequestMethod.POST)
    public ResponseEntity discoverTouristFriend(@RequestBody String data)throws Exception{
    	//there should be a bean
    	DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean = JSONHandler.parseFromJSON(data, DiscoverTouristFriendRequestBean.class);
    	BaseResponse response = touristFriendService.discoverTouristFriend(discoverTouristFriendRequestBean);
      
        return ResponseEntity.ok(response);

    }


    @CrossOrigin()
    @RequestMapping(value="/createChatGroup" , method = RequestMethod.POST)
    public ResponseEntity createChatGroup(@RequestBody String data)throws Exception{
    	CreateChatGroupRequestBean createChatGroupRequestBean= JSONHandler.parseFromJSON(data, CreateChatGroupRequestBean.class);
    	BaseResponse response= chatGroupService.createChatGroup(createChatGroupRequestBean);
    	
    	 return ResponseEntity.ok(response);
    	
    	
    }

    @CrossOrigin()
    @RequestMapping(value="/addTouristFriend", method= RequestMethod.POST)
    public ResponseEntity AddTouristFriend(@RequestBody String data)throws Exception{
    	AddFriendRequestBean addFriendRequestBean = JSONHandler.parseFromJSON(data, AddFriendRequestBean.class);
    	BaseResponse response = userFriendService.addTouristFriend(addFriendRequestBean);
    	
    	 return ResponseEntity.ok(response);
   
    }

    @CrossOrigin()
    @RequestMapping(value="/getUserFriends" , method = RequestMethod.POST)
    public ResponseEntity getTouristFriend(@RequestBody String data)throws Exception{
    	GetUserFriendRequest getUserFriendRequest= JSONHandler.parseFromJSON(data, GetUserFriendRequest.class);
    	BaseResponse response= userFriendService.getUserFriend(getUserFriendRequest);

    	
    	 return ResponseEntity.ok(response);
    	
    
    }

    @CrossOrigin()
    @RequestMapping(value="/discoverTouristAttraction")
    public ResponseEntity discoverTouristAttraction(@RequestBody String data) throws Exception{
    	DiscoverTouristAttractionRequestBean discoverTouristFriendRequestBean= JSONHandler.parseFromJSON(data, DiscoverTouristAttractionRequestBean.class);
    	BaseResponse response =touristAttractionService.discoverTouristAttraction(discoverTouristFriendRequestBean);
    	
    	 return ResponseEntity.ok(response);
    }

    @CrossOrigin()
    @RequestMapping(value="/addTouristAttraction", method= RequestMethod.POST)
    public ResponseEntity AddTouristAttraction(@RequestBody String data)throws Exception{
    	AddTouristAttractionRequestBean addTouristAttractionRequestBean = JSONHandler.parseFromJSON(data, AddTouristAttractionRequestBean.class);
    	BaseResponse response = touristAttractionService.addTouristAttraction(addTouristAttractionRequestBean);
    	
    	 return ResponseEntity.ok(response);
    	
    }

    @CrossOrigin()
    @RequestMapping(value="/addFriendToChatGroup")
    public ResponseEntity addFriendToChatGroup(@RequestBody String data) throws Exception{
    	AddFriendToChatGroupRequestBean addFriendToChatGroup = JSONHandler.parseFromJSON(data, AddFriendToChatGroupRequestBean.class);
    	BaseResponse response =groupParticipantService.addFriend(addFriendToChatGroup);

    	
    	 return ResponseEntity.ok(response);
    	
    	

    }

    @CrossOrigin()
    @RequestMapping(value="/userGroupChat")
    public ResponseEntity getChatGroup(@RequestBody String data) throws Exception{
    	GetUserChatGroupRequestBean getUserChatGroupRequestBean = JSONHandler.parseFromJSON(data, GetUserChatGroupRequestBean.class);
    	BaseResponse response =chatGroupService.getChatUserDetails(getUserChatGroupRequestBean);
    
    	 return ResponseEntity.ok(response);
    	
    
    }


    @CrossOrigin()
    @RequestMapping(value="/makeAdmin")
    public ResponseEntity makeAdmin(@RequestBody String data) throws Exception{
    	MakeAdminRequestBean makeAdminRequestBean = JSONHandler.parseFromJSON(data, MakeAdminRequestBean.class);
    	BaseResponse response =makeAdminService.makeAdmin(makeAdminRequestBean);
    
    	 return ResponseEntity.ok(response);
    	
    	
    }

    @CrossOrigin()
    @RequestMapping(value="/sendMessage" , method= RequestMethod.POST)
    public ResponseEntity sendMesssage(@RequestBody String data) throws Exception{
    	SendMessageRequestBean sendMessageRequestBean = JSONHandler.parseFromJSON(data, SendMessageRequestBean.class);
    	BaseResponse response= messageService.sendMessage(sendMessageRequestBean);

    	 return ResponseEntity.ok(response);
    	

    }


    @CrossOrigin()
    @RequestMapping(value="/getMessage/{chatId}" , method= RequestMethod.GET)
    public ResponseEntity getMessage(@PathVariable("chatId") int chatId) throws Exception{
    	BaseResponse response= messageService.getMessage(chatId);
    	
    	 return ResponseEntity.ok(response);
    	
  
    }

    @CrossOrigin()
    @RequestMapping(value="/deleteChatGroupMember" , method= RequestMethod.POST)
    public ResponseEntity deleteMember(@RequestBody String data) throws Exception{
    	DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean = JSONHandler.parseFromJSON(data, DeleteChatGroupMemberRequestBean.class);
    	BaseResponse response= groupParticipantService.deleteMember(deleteChatGroupMemberRequestBean);
    	
    	 return ResponseEntity.ok(response);
    	
    }

    @CrossOrigin()
    @RequestMapping(value="/searchFriend/{firstname}" , method= RequestMethod.GET)
    public ResponseEntity searchFriend(@PathVariable("firstname") String data) throws Exception{
    //	DeleteChatGroupMemberRequestBean deleteChatGroupMemberRequestBean = JSONHandler.parseFromJSON(data, DeleteChatGroupMemberRequestBean.class);
    	BaseResponse response= touristFriendService.searchFriend(data);
    	
    	 return ResponseEntity.ok(response);

    }

    @CrossOrigin()
    @RequestMapping(value="/addTouristService" , method= RequestMethod.POST)
    public ResponseEntity addTouristService(@RequestBody String data) throws Exception{
    	AddTouristServiceRequestBean addTouristServiceRequestBean = JSONHandler.parseFromJSON(data, AddTouristServiceRequestBean.class);
    	BaseResponse response= touristService.addTouristService(addTouristServiceRequestBean);
    	
    	 return ResponseEntity.ok(response);
    	
  

    }
    @CrossOrigin()
    @RequestMapping(value="/getTouristService/{serviceTitle}" , method= RequestMethod.GET)
    public ResponseEntity getService(@PathVariable("serviceTitle") String data) throws Exception{
    	BaseResponse response= touristService.getTouristServicesByTitle(data);
    	
    	 return ResponseEntity.ok(response);
    	
    }

    @CrossOrigin()
    @RequestMapping(value="/getAllTouristService" , method= RequestMethod.GET)
    public ResponseEntity getAllServices() throws Exception{
    	BaseResponse response= touristService.getAllTouristServices();
    	
    	 return ResponseEntity.ok(response);
    	
    }


    @CrossOrigin()
    @RequestMapping(value="/addServiceProvider" , method= RequestMethod.POST)
    public ResponseEntity addServiceProvider(@RequestBody String data) throws Exception{
    	AddServiceProviderRequestBean addServiceProviderRequestBean = JSONHandler.parseFromJSON(data, AddServiceProviderRequestBean.class);
    	BaseResponse response= touristService.addServiceProvider(addServiceProviderRequestBean);
    	
    	 return ResponseEntity.ok(response);
    }
    @CrossOrigin()
    @RequestMapping(value="/contactTouristGuideSendMessage" , method= RequestMethod.POST)
    public ResponseEntity ContactTouristGuideSendMessage(@RequestBody String data) throws Exception{
    	ContactTouristGuideSendMessageRequestBean contactTouristGuideSendMessageRequestBean = JSONHandler.parseFromJSON(data, ContactTouristGuideSendMessageRequestBean.class);
    	BaseResponse response=  messageService.sendMessageToTouristGuide(contactTouristGuideSendMessageRequestBean);
    	
    	 return ResponseEntity.ok(response);
    }


    @CrossOrigin()
    @RequestMapping(value="/contactTouristGuideGetMessage" , method= RequestMethod.POST)
    public ResponseEntity ContactTouristGuideGetMessage(@RequestBody String data) throws Exception{
    	ContactTouristGuideGetMessageRequestBean contactTouristGuideGetMessageRequestBean = JSONHandler.parseFromJSON(data, ContactTouristGuideGetMessageRequestBean.class);
    	BaseResponse response= messageService.getMessageFromTouristGuide(contactTouristGuideGetMessageRequestBean);

    	
    	 return ResponseEntity.ok(response);

    }




}
