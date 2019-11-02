package com.cyntex.TourismApp.Beans;

import java.util.List;

public class GetMessageResponseBean extends BaseResponse {
	
	
	   private List<SendMessageQueryResponsBean> messageReponseList;

		public List<SendMessageQueryResponsBean> getMessageReponseList() {
			return messageReponseList;
		}
		
		public void setMessageReponseList(
				List<SendMessageQueryResponsBean> messageReponseList) {
			this.messageReponseList = messageReponseList;
		}
}
