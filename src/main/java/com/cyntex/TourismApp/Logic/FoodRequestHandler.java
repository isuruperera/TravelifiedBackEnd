package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.FoodRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FoodRequestHandler {

    private static final String MAPS_URL = "https://maps.google.com/maps?q=";

    private static final Long MAX_TIME_DIFF = 300000L;

    @Autowired
    private FoodRequestDAO foodRequestDao;

    public BaseResponse handle(ShopDetailsRequestBean requestBean) {
        ShopDetailsResponseBean shopDetailsResponseBean = new ShopDetailsResponseBean();
        // adjust time
        long now = System.currentTimeMillis();
        long timeDiff = Math.abs(now-requestBean.getTime());

        if(timeDiff > MAX_TIME_DIFF) {
            shopDetailsResponseBean.setStatus("FAILED: Cannot validate request time. Time should be in GMT:+5:30");
            return shopDetailsResponseBean;
        } else {
            Date date = new Date();
            Date today = new Date(date.getYear(),date.getMonth(),date.getDate());
            requestBean.setTime((now - today.getTime())/1000);
            
            try {
                List<ShopDetailsQueryResultBean> resultBeans
                        = foodRequestDao.getFoodItemsForTime(requestBean.getTime());

                Map<Integer, ShopDetailsBean> shopDetailsMapper = new HashMap<>();
                resultBeans.forEach(shopDetailsQueryResultBean -> {
                    ShopDetailsBean shopDetailsBean = shopDetailsMapper.get(shopDetailsQueryResultBean.getShopID());
                    if(shopDetailsBean == null) {
                        shopDetailsBean = new ShopDetailsBean();
                        shopDetailsBean.setShopName(shopDetailsQueryResultBean.getShopName());
                        shopDetailsBean.setLocationURL(MAPS_URL
                                +shopDetailsQueryResultBean.getLongitude()+","+shopDetailsQueryResultBean.getLatitude());
                        shopDetailsBean.setShopId(shopDetailsQueryResultBean.getShopID());
                        shopDetailsMapper.put(shopDetailsQueryResultBean.getShopID(),shopDetailsBean);
                    }
                    FoodItem foodItem = new FoodItem();
                    foodItem.setItemId(shopDetailsQueryResultBean.getFoodID());
                    foodItem.setItemName(shopDetailsQueryResultBean.getFoodName());
                    foodItem.setItemPrice(shopDetailsQueryResultBean.getFoodPrice());
                    List<FoodItem> foodItems = shopDetailsBean.getFoodItems();
                    if(foodItems == null) {
                        foodItems = new ArrayList<>();
                        shopDetailsBean.setFoodItems(foodItems);
                    }
                    foodItems.add(foodItem);
                });
                List<ShopDetailsBean> shopDetailsBeans = new ArrayList<>(shopDetailsMapper.values());
                shopDetailsResponseBean.setShopDetails(shopDetailsBeans);
                shopDetailsResponseBean.setStatus("SUCCESS");
            } catch (Exception e) {
                shopDetailsResponseBean.setStatus("FAILED: Cannot load the foods list.");
            }
            return shopDetailsResponseBean;
        }
    }
}
