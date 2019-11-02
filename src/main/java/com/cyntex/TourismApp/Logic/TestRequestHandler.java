package com.cyntex.TourismApp.Logic;

import com.cyntex.TourismApp.Beans.TestBean;
import com.cyntex.TourismApp.Persistance.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestRequestHandler {

    @Autowired
    private TestDAO testDAO;

    public void handle(TestBean testBean) {
        try {
            testDAO.runTestUpdateQuery(testBean.getUsername(), testBean.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
