package com.kyle.crud.bean;

public class Dormitory {
    private Integer dormId;

    private String dormName;

    public Dormitory() {
    }

    public Dormitory(Integer dormId, String dormName) {
        this.dormId = dormId;
        this.dormName = dormName;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName == null ? null : dormName.trim();
    }
}