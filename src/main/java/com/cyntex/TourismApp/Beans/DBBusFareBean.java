package com.cyntex.TourismApp.Beans;

public class DBBusFareBean {

    private final double normalFare;
    private final double semiLuxuryFare;
    private final double luxuryFare;
    private final double expressFare;

    public DBBusFareBean(double normalFare, double semiLuxuryFare, double luxuryFare, double expressFare) {
        this.normalFare = normalFare;
        this.semiLuxuryFare = semiLuxuryFare;
        this.luxuryFare = luxuryFare;
        this.expressFare = expressFare;
    }

    public double getNormalFare() {
        return normalFare;
    }


    public double getSemiLuxuryFare() {
        return semiLuxuryFare;
    }

    public double getLuxuryFare() {
        return luxuryFare;
    }

    public double getExpressFare() {
        return expressFare;
    }
}
