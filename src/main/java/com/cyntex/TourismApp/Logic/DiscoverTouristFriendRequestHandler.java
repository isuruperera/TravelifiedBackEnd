package com.cyntex.TourismApp.Logic;


import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Beans.ProfileResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Persistance.FriendListDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;
import com.cyntex.TourismApp.Persistance.UserRatingsProfileDAO;
import com.cyntex.TourismApp.Util.UserRatingCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscoverTouristFriendRequestHandler {

	@Autowired
	private UserRatingCalculator userRatingCalculator;

	@Autowired
	private UserRatingsProfileDAO userRatingsProfileDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FriendListDAO friendListDAO;
	

    @Transactional(propagation=Propagation.REQUIRED,rollbackFor= Exception.class ,  timeout=120)
	public List<DiscoverTouristFriendUserProfileQueryResponseBean> discoverTouristFriend (
		DiscoverTouristFriendRequestBean discoverTouristFriendRequestBean) throws Exception {

		ProfileResponseBean ProfileResponseBean = new ProfileResponseBean();
		
		List<UserRating> requestedUserRatingList = new ArrayList<UserRating>();
		
		List<DiscoverTouristFriendUserProfileQueryResponseBean> touristFriendProfileList = new ArrayList<DiscoverTouristFriendUserProfileQueryResponseBean>();
		String requesterUsername=discoverTouristFriendRequestBean.getUsername();
	 
			if(!StringUtils.isEmpty(requesterUsername)){
			List<RatingsProfileQueryResponseBean> queryResponse = userRatingsProfileDAO
					.getUserRatingsProfile(requesterUsername);

			requestedUserRatingList = userRatingCalculator
					.RatingProfileResponse(queryResponse).getUserRatings();
				ProfileResponseBean = userRatingCalculator.RatingProfileResponse(queryResponse);// this won't use
			ArrayList<String> counterBucket = new ArrayList<String>();
			for (UserRating userRating : requestedUserRatingList) {

				List<DiscoverTouristFriendRatingDetailQueryResponseBean> discoverTouristFriendQuaryResponseBeanList = userRatingsProfileDAO.getAverageRating(userRating.getCategory(),requesterUsername);
              // getting  average rating of current user 
				for (DiscoverTouristFriendRatingDetailQueryResponseBean discoverTouristFriendRatingDetailQueryResponseBean : discoverTouristFriendQuaryResponseBeanList) {
					double averageRating = discoverTouristFriendRatingDetailQueryResponseBean.getAverageRating();
					String usernameOfQuaryResponseBean=discoverTouristFriendRatingDetailQueryResponseBean.getUsername();
					boolean isRecordAlreadyExists=friendListDAO.isRecordAlreadyExists(requesterUsername, usernameOfQuaryResponseBean);
					if ( !isRecordAlreadyExists &&(!counterBucket.contains(usernameOfQuaryResponseBean))&& averageRating >= userRating.getRating() - 1
							&& averageRating <= userRating.getRating() + 1) {
						counterBucket.add(usernameOfQuaryResponseBean);
						touristFriendProfileList.add(userDAO.getDiscoveryProfile(usernameOfQuaryResponseBean));
						if (touristFriendProfileList.size() >= 10) {
							break;
						}
					}

				}

			}
			}else{
				throw new BadRequestException("FAILED:Check the payload Again");				
			}

		
		return touristFriendProfileList;

	
     }

}
