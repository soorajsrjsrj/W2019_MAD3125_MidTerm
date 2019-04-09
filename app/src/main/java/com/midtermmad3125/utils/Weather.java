package com.midtermmad3125.utils;

public class Weather {
    private String mcity;
    private String mid;
    private String mcoord;
    private String mlon;
    private String mlat;
    private String mcountry;
    private String mpopulation;

    public Weather(String city, String id, String coord,String lon,String lat, String country,String population) {
        mcity=city;
        mid=id;
        mcoord=coord;
        mlon=lon;
        mlat=lat;
        mcountry=country;
        mpopulation=population;
    }

    public String getMcity() {
        return mcity;
    }

    public void setMcity(String mcity) {
        this.mcity = mcity;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMcoord() {
        return mcoord;
    }

    public void setMcoord(String mcoord) {
        this.mcoord = mcoord;
    }

    public String getMlon() {
        return mlon;
    }

    public void setMlon(String mlon) {
        this.mlon = mlon;
    }

    public String getMlat() {
        return mlat;
    }

    public void setMlat(String mlat) {
        this.mlat = mlat;
    }

    public String getMcountry() {
        return mcountry;
    }

    public void setMcountry(String mcountry) {
        this.mcountry = mcountry;
    }

    public String getMpopulation() {
        return mpopulation;
    }

    public void setMpopulation(String mpopulation) {
        this.mpopulation = mpopulation;
    }
}
