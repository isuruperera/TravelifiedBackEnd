package com.cyntex.TourismApp.Persistance;

import com.cyntex.TourismApp.Beans.ShopDetailsQueryResultBean;
import com.cyntex.TourismApp.Util.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Component
public class FoodRequestDAO {

    private static final String foodShopDetailsQuery
            = "select * from food_shop as fs,food_item as fi,food_shop_time as ft " +
            "where " +
            "fs.shop_id = ft.shop_id and " +
            "ft.item_id = fi.item_id and " +
            "ft.end > ? and " +
            "ft.start < ? ";

 
    @Autowired
    private DataSourceManager dataSourceManager;

    @Transactional
    public List<ShopDetailsQueryResultBean> getFoodItemsForTime(Long time){
        List<ShopDetailsQueryResultBean> queryData = dataSourceManager.getJdbcTemplate().query(
                foodShopDetailsQuery,
                new Object[] {time,time},
                new int[]{Types.BIGINT,Types.BIGINT},
                (rs,rowNum) -> new ShopDetailsQueryResultBean(
                        rs.getString("shop_name"),
                        rs.getInt("shop_id"),
                        rs.getString("longitude"),
                        rs.getString("latitude"),
                        rs.getString("item_name"),
                        rs.getInt("item_id"),
                        rs.getDouble("price"))
        );
        return queryData;
    }


}
