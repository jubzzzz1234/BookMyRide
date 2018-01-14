package com.example.jubin.bookmyride;

/**
 * Created by jubin on 29/11/17.
 */

public class ModelClass {

    String Car;
    String BaseFare;
    String Extra;
    String Name;
    String No;
    String Purpose;
    String Date;
    String Time;
    String Status;

    public ModelClass(String car, String baseFare, String extra, String name, String no, String purpose, String date, String time, String status) {
        Car = car;
        BaseFare = baseFare;
        Extra = extra;
        Name = name;
        No = no;
        Purpose = purpose;
        Date = date;
        Time = time;
        Status = status;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String car) {
        Car = car;
    }

    public String getBaseFare() {
        return BaseFare;
    }

    public void setBaseFare(String baseFare) {
        BaseFare = baseFare;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
