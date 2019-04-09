package com.midtermmad3125.utils;

public class ListWeather {
    private String dt;
    private String pressure;
    private String humidity;
    private String speed;

    public ListWeather(String dt, String pressure, String humidity, String speed) {
        this.dt = dt;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speed = speed;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
