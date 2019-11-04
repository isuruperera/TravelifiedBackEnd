package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.AddTouristAttractionRequestBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionPlaceQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionQueryResponseBean;
import com.cyntex.TourismApp.Beans.DiscoverTouristAttractionRequestBean;
import com.cyntex.TourismApp.Exception.BadRequestException;
import com.cyntex.TourismApp.Persistance.TouristAttractionDAO;
import com.cyntex.TourismApp.Persistance.TouristAttractionPhotoCollectionDAO;
import com.cyntex.TourismApp.Util.FSManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class TouristAttractionRequestHandler {

	
	@Autowired
	TouristAttractionDAO touristAttractionDAO;
	
	@Autowired
	TouristAttractionPhotoCollectionDAO touristAttractionPhotoCollectionDAO;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor= Exception.class ,  timeout=120)  
    public void addTouristAttraction(AddTouristAttractionRequestBean addTouristAttractionRequestBean) throws Exception{
    	String attractionName=addTouristAttractionRequestBean.getAttractionName();
    	String description=addTouristAttractionRequestBean.getDescription();
    	String ratingProfileId=addTouristAttractionRequestBean.getRatingProfileId();
    	String titlePhoto=addTouristAttractionRequestBean.getTitlePhoto();
    	String[] photoCollection=addTouristAttractionRequestBean.getPhotoCollection();
    	double lng=addTouristAttractionRequestBean.getLng();
    	double lat=addTouristAttractionRequestBean.getLat();
			
			if(!(StringUtils.isEmpty(attractionName)||StringUtils.isEmpty(description)||StringUtils.isEmpty(ratingProfileId)
					||StringUtils.isEmpty(titlePhoto)||
					StringUtils.isEmpty(photoCollection))){
				
				String titlePhotoID = UUID.randomUUID().toString();
			    FSManager.saveImage(titlePhotoID, titlePhoto);
			    
			    String photoCollectionId = UUID.randomUUID().toString();
				
			    touristAttractionDAO.addTouristAttraction(attractionName,description,ratingProfileId,titlePhotoID,photoCollectionId,lng,lat);
				for(String photo : photoCollection){
					if(!StringUtils.isEmpty(photo)){
						String photoUrl = UUID.randomUUID().toString();
						FSManager.saveImage(photoUrl, photo);
						 
						touristAttractionPhotoCollectionDAO.addPhotoCollection(photoCollectionId, photoUrl);
					 
					}else{
						throw new BadRequestException("check the payload again : problem with photo collection ");
					}
				}

				
			}else{
				throw new BadRequestException("FAILED :Check the payload");

			}
					
    	
    }
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor= Exception.class ,  timeout=120)
	public List<DiscoverTouristAttractionPlaceQueryResponseBean> getTouristAttraction(DiscoverTouristAttractionRequestBean discoverTouristAttractionRequestBean) throws Exception{
		List<DiscoverTouristAttractionPlaceQueryResponseBean> discoverTouristAttractionResponseBeanList= new ArrayList<DiscoverTouristAttractionPlaceQueryResponseBean>();
		DiscoverTouristAttractionPlaceQueryResponseBean discoverTouristAttractionPlaceQueryResponseBean;
		
		List<DiscoverTouristAttractionQueryResponseBean> discoverTouristAttractionQuaryResponseBeanList =touristAttractionDAO.getUserRatingsProfile();
			
			double currentLongitude=discoverTouristAttractionRequestBean.getLongitude();
			double currentLatitude=discoverTouristAttractionRequestBean.getLatitude();
			
			if(!(StringUtils.isEmpty(currentLongitude) || StringUtils.isEmpty(currentLatitude))){
			for(DiscoverTouristAttractionQueryResponseBean discoverTouristAttractionQueryResponseBean:discoverTouristAttractionQuaryResponseBeanList){
				double longitude =discoverTouristAttractionQueryResponseBean.getLongitude();
				double latitude =discoverTouristAttractionQueryResponseBean.getLatitude();
		
				if(isAttractivePlace(currentLatitude,currentLongitude,latitude,longitude)){
					discoverTouristAttractionPlaceQueryResponseBean=touristAttractionDAO.getTouristAttraction(discoverTouristAttractionQueryResponseBean.getAttraction_id());
					discoverTouristAttractionPlaceQueryResponseBean.setPhotoUrlCollection(touristAttractionPhotoCollectionDAO.getPhotoCollection(discoverTouristAttractionPlaceQueryResponseBean.getPhotoCollectionId()));	
					discoverTouristAttractionResponseBeanList.add(discoverTouristAttractionPlaceQueryResponseBean);
                }
                if (discoverTouristAttractionResponseBeanList.size() >= 25) {
                    break;
                }
			}
		
	
			}else{
				throw new BadRequestException("Check the payload again");
			}
		
		return discoverTouristAttractionResponseBeanList;
	}
	
	
	
	public boolean isAttractivePlace(double lat1,double long1,double lat2,double long2){
		if(HaversineInM(lat1,long1,lat2,long2)<100){
			return true;
		}else{return false;}
		
	}
    static final double _eQuatorialEarthRadius = 6371D;
    static final double _d2r = (Math.PI / 180D);

    public  double HaversineInM(double lat1, double long1, double lat2, double long2) {
    	 
        return HaversineInKM(lat1, long1, lat2, long2);
    }

    public  double HaversineInKM(double lat1, double long1, double lat2, double long2) {
    	
    	double dlat = (lat2 - lat1) * _d2r;
    	double dlong = (long2 - long1) * _d2r;
    	
    	lat1=lat1*_d2r;
    	lat2=lat2*_d2r;
       
        double a =Math.sin(dlat / 2)*Math.sin(dlat / 2) + 
        		Math.sin(dlong/2) * Math.sin(dlong/2)
                * Math.cos(lat1)*Math.cos(lat2);
        double c = 2* Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = _eQuatorialEarthRadius * c;
        
       
   //     System.out.println("distance "+ Math.abs(distance));
        return Math.abs(distance);
    }

}
