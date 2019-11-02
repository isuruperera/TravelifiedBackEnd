package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.*;
import com.cyntex.TourismApp.Persistance.TransportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransportDataRequestHandler {

    @Autowired
    private TransportDAO transportDAO;

    public BaseResponse handle(TransportDataRequestBean transportDataRequestBean) {
        TransportDataResponseBean transportDataResponseBean = new TransportDataResponseBean();
        if (transportDataRequestBean.getRequestType() == 1) {
            transportDataResponseBean.setCities(transportDAO.getFromTowns());
            transportDataResponseBean.setStatus("SUCCESS");
        } else if (transportDataRequestBean.getRequestType() == 2) {
            transportDataResponseBean.setCities(transportDAO.getToTowns());
            transportDataResponseBean.setStatus("SUCCESS");
        } else {
            transportDataResponseBean.setStatus("FAILED: Data type not selected!");
        }
        return transportDataResponseBean;
    }

    public BaseResponse handle(BusInformationRequestBean busInformationRequestBean) {
        BusInformationResponseBean busInformationResponseBean = new BusInformationResponseBean();
        List<DBBusFareBean> dbBusFareBeas = transportDAO.getTransportInfoForTowns(busInformationRequestBean.getFrom(),
                                                                                  busInformationRequestBean.getTo());
        if (!dbBusFareBeas.isEmpty()) {
            DBBusFareBean dbBusFareBean = dbBusFareBeas.get(0);
            List<BusFareBean> busFares = new ArrayList<>();
            if (dbBusFareBean.getNormalFare() != 0D) {
                busFares.add(new BusFareBean("Normal", dbBusFareBean.getNormalFare()));
            }
            if (dbBusFareBean.getSemiLuxuryFare() != 0D) {
                busFares.add(new BusFareBean("Semi Luxury", dbBusFareBean.getSemiLuxuryFare()));
            }
            if (dbBusFareBean.getLuxuryFare() != 0D) {
                busFares.add(new BusFareBean("Luxury", dbBusFareBean.getLuxuryFare()));
            }
            if (dbBusFareBean.getExpressFare() != 0D) {
                busFares.add(new BusFareBean("Expressway", dbBusFareBean.getExpressFare()));
            }
            busInformationResponseBean.setBusFares(busFares);
            busInformationResponseBean.setStatus("SUCCESS");
        } else {
            busInformationResponseBean.setStatus("FAILED: No information found");
        }
        return busInformationResponseBean;
    }

    public BaseResponse handle(LocationCoordinateRequestBean locationCoordinateRequestBean) {
        LocationCoordinateResponseBean locationCoordinateResponseBean = new LocationCoordinateResponseBean();
        List<LocationBean> locations = transportDAO.getLocation(locationCoordinateRequestBean.getLocationID());

        if (!locations.isEmpty()) {
            locationCoordinateResponseBean.setLatitude(locations.get(0).getLatitude());
            locationCoordinateResponseBean.setLongitude(locations.get(0).getLongitude());
            locationCoordinateResponseBean.setStatus("SUCCESS");
        } else {
            locationCoordinateResponseBean.setStatus("FAIL: Location not found!");
        }
        return locationCoordinateResponseBean;
    }

    public BaseResponse handle(DiscoverRequestBean discoverRequestBean) {
        DiscoverResponseBean discoverResponseBean = new DiscoverResponseBean();
        discoverResponseBean.setStatus("SUCCESS");
        discoverResponseBean.setAttaractions(transportDAO.getAttaractions(discoverRequestBean.getLocationID()));
        return discoverResponseBean;
    }

    public BaseResponse handle(TransportFeeCalculateRequestBean transportFeeCalculateRequestBean) {
        TransportFeeCalculateResponseBean busFareEstimationBean = new TransportFeeCalculateResponseBean();
        double totalFee = 0;
        for (BusFareRequestBean busFareRequestBean : transportFeeCalculateRequestBean.getRequest()) {
            List<DBBusFareBean> busFares = transportDAO.getTransportInfoForTowns(busFareRequestBean.getFrom(),
                                                                                 busFareRequestBean.getTo());
            if (!busFares.isEmpty()) {
                switch (busFareRequestBean.getCategory()) {
                    case "Normal":
                        totalFee += busFares.get(0).getNormalFare();
                        break;
                    case "Semi Luxury":
                        totalFee += busFares.get(0).getSemiLuxuryFare();
                        break;
                    case "Luxury":
                        totalFee += busFares.get(0).getLuxuryFare();
                        break;
                }
            }

        }
        busFareEstimationBean.setFareEstimation(totalFee);
        busFareEstimationBean.setStatus("SUCCESS");
        return busFareEstimationBean;
    }


}
