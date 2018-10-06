package com.insourceit.lms.dto;

import java.io.Serializable;

public class BorrowerDto implements Serializable {
    private static final long serialVersionUID = -8761186593729086399L;
    private String uniqueID;
    private String fname;
    private String lname;
    private String business;
    private String gender;
    private String title;
    private String mobile;
    private String landphone;
    private String email;
    private String regdate;
    private String address;
    private String city;
    private String province;
    private String workstatus;
    private String description;
    private String files;
    private String registeredby;

    public BorrowerDto() {
    }

    public BorrowerDto(String uniqueID, String fname, String lname, String business, String gender, String title, String mobile, String landphone, String email, String regdate, String address, String city, String province, String workstatus, String description, String files, String registeredby) {
        this.uniqueID = uniqueID;
        this.fname = fname;
        this.lname = lname;
        this.business = business;
        this.gender = gender;
        this.title = title;
        this.mobile = mobile;
        this.landphone = landphone;
        this.email = email;
        this.regdate = regdate;
        this.address = address;
        this.city = city;
        this.province = province;
        this.workstatus = workstatus;
        this.description = description;
        this.files = files;
        this.registeredby = registeredby;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandphone() {
        return landphone;
    }

    public void setLandphone(String landphone) {
        this.landphone = landphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getRegisteredby() {
        return registeredby;
    }

    public void setRegisteredby(String registeredby) {
        this.registeredby = registeredby;
    }
}
