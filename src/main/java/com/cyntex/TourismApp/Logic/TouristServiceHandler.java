package com.cyntex.TourismApp.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cyntex.TourismApp.Beans.AddTouristServiceRequestBean;
import com.cyntex.TourismApp.Beans.AddTouristServiceResponseBean;
import com.cyntex.TourismApp.Beans.BaseResponse;
import com.cyntex.TourismApp.Beans.GetTouristServiceQueryResponseBean;
import com.cyntex.TourismApp.Beans.GetTouristServiceResponseBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Exception.PermissionDeniedException;
import com.cyntex.TourismApp.Persistance.TouristServiceDAO;
import com.cyntex.TourismApp.Persistance.TouristServicePhotoCollectionDAO;
import com.cyntex.TourismApp.Persistance.UserDAO;
import com.cyntex.TourismApp.Util.FSManager;


@Component
public class TouristServiceHandler {
	
	@Autowired
	TouristServiceDAO touristServiceDAO; 
	@Autowired
	TouristServicePhotoCollectionDAO touristServicePhotoCollectionDAO;
	

	
	@Autowired
	UserDAO userDAO;
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor= Exception.class, timeout=120)
	public BaseResponse addTouristService(AddTouristServiceRequestBean addTouristServiceRequestBean) throws Exception{
		String addedBy=addTouristServiceRequestBean.getAddedBy();
		String ownername=addTouristServiceRequestBean.getOwnername();
		String ratingProfileId=addTouristServiceRequestBean.getRatingProfileId();
		String serviceDescription=addTouristServiceRequestBean.getServiceDescription();
		String serviceTitle=addTouristServiceRequestBean.getServiceTitle();
		String titlePhoto=addTouristServiceRequestBean.getTitlePhoto();
		String[] photoCollection=addTouristServiceRequestBean.getPhotoCollection();
		double lng= addTouristServiceRequestBean.getLng();
		double lat=addTouristServiceRequestBean.getLat();
		
		AddTouristServiceResponseBean response = new AddTouristServiceResponseBean();
	
			if(userDAO.isAdmin(addedBy)){
				
				if(!(StringUtils.isEmpty(ownername)||StringUtils.isEmpty(photoCollection)||
						StringUtils.isEmpty(ratingProfileId)||StringUtils.isEmpty(serviceDescription)||StringUtils.isEmpty(serviceTitle)||
						StringUtils.isEmpty(titlePhoto))){
					
					String titlePhotoID = UUID.randomUUID().toString();
				    FSManager.saveImage(titlePhotoID, titlePhoto);
				    
				    String photoCollectionId = UUID.randomUUID().toString();
					
					touristServiceDAO.addTouristService(serviceTitle,serviceDescription,ownername,titlePhotoID,photoCollectionId,ratingProfileId,lng,lat);
				
					for(String photo : photoCollection){
						if(!StringUtils.isEmpty(photo)){
							String photoUrl = UUID.randomUUID().toString();
							FSManager.saveImage(photoUrl, photo);
							 
							touristServicePhotoCollectionDAO.addPhotoCollection(photoCollectionId, photoUrl);
						 
						}else{throw new BadRequestException("FAILED :Check the payload");}
					}
	
					
				}else{
					throw new BadRequestException("FAILED :Check the payload");
					
				}
					
			}else{
				throw new PermissionDeniedException("FAILED:you are not an admin");
				
			}

		
		return response;
	}
	
	@Transactional(rollbackFor= Exception.class, timeout=120)
	public List<GetTouristServiceQueryResponseBean> getTouristServiceByTitle(String title) throws Exception{
		
		List<GetTouristServiceQueryResponseBean> queryResponseList= new ArrayList();

			for(GetTouristServiceQueryResponseBean queryResponseBean:touristServiceDAO.getTouristServiceByTitle(title)){
				queryResponseBean.setPhotoUrlCollection(touristServicePhotoCollectionDAO.getPhotoCollection(queryResponseBean.getPhotoCollectionId()));
				queryResponseList.add(queryResponseBean);
			}
			
		
		return queryResponseList;
	}
	
	@Transactional(rollbackFor= Exception.class, timeout=120)
	public List<GetTouristServiceQueryResponseBean> getAllTouristServices() throws Exception{
		List<GetTouristServiceQueryResponseBean> queryResponseList= new ArrayList();	
			for(GetTouristServiceQueryResponseBean queryResponseBean: touristServiceDAO.getAllTouristServices()){
				queryResponseBean.setPhotoUrlCollection(touristServicePhotoCollectionDAO.getPhotoCollection(queryResponseBean.getPhotoCollectionId()));
				queryResponseList.add(queryResponseBean);
			}

		return queryResponseList;
		
	}

}
