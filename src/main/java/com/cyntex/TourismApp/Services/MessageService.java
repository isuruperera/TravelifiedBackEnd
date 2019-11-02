package com.cyntex.TourismApp.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideGetMessageResponseBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageRequestBean;
import com.cyntex.TourismApp.Beans.ContactTouristGuideSendMessageResponseBean;
import com.cyntex.TourismApp.Beans.GetMessageRequestBean;
import com.cyntex.TourismApp.Beans.GetMessageResponseBean;
import com.cyntex.TourismApp.Beans.SendMessageRequestBean;
import com.cyntex.TourismApp.Beans.SendMessageResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.DataMismatchException;
import com.cyntex.TourismApp.Logic.MesssageServiceHandler;
import com.cyntex.TourismApp.Logic.TouristGuideServiceHandler;


@Service
public class MessageService {
	
	@Autowired
	private MesssageServiceHandler messsageServiceHandler;
	
	@Autowired
	private TouristGuideServiceHandler touristGuideServiceHandler;
	

	public BaseResponse sendMessage(SendMessageRequestBean requestBean){
		SendMessageResponseBean baseResponse = new SendMessageResponseBean();
		
		try{
			messsageServiceHandler.sendMessage(requestBean);
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			baseResponse.setStatus(e.getMessage());
			
		}
		catch(Exception e){
			baseResponse.setStatus("Transaction fails"+e.getMessage());	
		}
		return baseResponse;
	}

	public BaseResponse getMessage(int chatId){
		GetMessageResponseBean baseResponse = new GetMessageResponseBean();
		try{
			baseResponse.setMessageReponseList(messsageServiceHandler.getMessage(chatId));
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			
			baseResponse.setStatus(e.getMessage());
			
		}	
		catch(Exception e){
			
			baseResponse.setStatus("Transaction fails"+e.getMessage());
			
		}
		return baseResponse;
	}
	
	public BaseResponse sendMessageToTouristGuide(ContactTouristGuideSendMessageRequestBean requestBean){
		ContactTouristGuideSendMessageResponseBean baseResponse= new ContactTouristGuideSendMessageResponseBean();
		try{
			touristGuideServiceHandler.sendMessage(requestBean);
			
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){
			
			baseResponse.setStatus(e.getMessage());
			
		}catch(DataMismatchException e){
			baseResponse.setStatus(e.getMessage());	
		}	
		catch(Exception e){
			
			baseResponse.setStatus("Transaction fails"+e.getMessage());
			
		}
		return baseResponse;
	}

	
	public BaseResponse getMessageFromTouristGuide(ContactTouristGuideGetMessageRequestBean requestBean){
		ContactTouristGuideGetMessageResponseBean baseResponse= new ContactTouristGuideGetMessageResponseBean();
		
		try{
			baseResponse.setResponseList(touristGuideServiceHandler.getMessage(requestBean));
		    baseResponse.setStatus("SUCCESS");

		}catch(BadRequestException e){	
			baseResponse.setStatus(e.getMessage());	
		}	
		catch(Exception e){
			baseResponse.setStatus("Transaction fails "+e.getMessage());
			
		}
		return baseResponse;
	}



}


