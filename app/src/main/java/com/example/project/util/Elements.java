package com.example.project.util;

public class Elements {
    public double coast;
    public String onePoint;
    public String twoPoint;
    public String time;

    public Elements(double coast, String onePoint, String twoPoint, String time) {
        this.coast = coast;
        this.onePoint = onePoint;
        this.twoPoint = twoPoint;
        this.time = time;
    }

    public Elements() {
        coast = 51;
        onePoint = "Первомайская 21";
        twoPoint = "Пинского 2";
        time = "34";
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public String getOnePoint() {
        return onePoint;
    }

    public void setOnePoint(String onePoint) {
        this.onePoint = onePoint;
    }

    public String getTwoPoint() {
        return twoPoint;
    }

    public void setTwoPoint(String twoPoint) {
        this.twoPoint = twoPoint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
