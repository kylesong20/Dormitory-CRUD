package com.kyle.crud.bean;

import javax.validation.constraints.Pattern;

public class Student {
    private Integer stuId;

    @Pattern(regexp="(^[a-z0-9_-]{4,16}$)|(^[\u2E80-\u9FFF]{2,5})",
            message = "用户名可以是2-5为中文或者4-16位英文和数字的组合")
    private String stuName;

    private String gender;
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$",
            message = "手机格式不正确")
    private String telNum;

    private String dormNum;

    private Integer dormId;


    //    希望查询student时也查询dormitory
    private Dormitory dormitory;

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Student() {
    }

    public Student(Integer stuId, String stuName, String gender, String telNum, String dormNum, Integer dormId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.gender = gender;
        this.telNum = telNum;
        this.dormNum = dormNum;
        this.dormId = dormId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum == null ? null : dormNum.trim();
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }
}