package com.insourceit.lms.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_borrower")
public class Borrower implements Serializable {
    private static final long serialVersionUID = 1867734337555511037L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bid")
    private int bid;
    @Column(name = "idt_borrower")
    private String uniqueID;
    @Column(name = "t_borrower_frist_name")
    private String fname;
    @Column(name = "t_borrower_last_name")
    private String lname;
    @Column(name = "t_borrower_business")
    private String business;
    @Column(name = "t_borrower_gender")
    private String gender;
    @Column(name = "t_borrower_title")
    private String title;
    @Column(name = "t_borrower_mobile")
    private String mobile;
    @Column(name = "t_borrower_land_phone")
    private String landphone;
    @Column(name = "t_borrower_email")
    private String email;
    @Column(name = "t_borrower_reg_date")
    private String regdate;
    @Column(name = "t_borrower_address")
    private String address;
    @Column(name = "t_borrower_city")
    private String city;
    @Column(name = "t_borrower_province")
    private String province;
    @Column(name = "t_borrower_work_status")
    private String workstatus;
    @Column(name = "t_borrower_description")
    private String description;
    @Column(name = "t_borrower_files")
    private String files;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_borrower_registered_by")
    private User registeredby;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_group")
    private MemberGroup group;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrower", fetch = FetchType.LAZY)
    private List<Loan> borrowedLoans = new ArrayList<>();


    public Borrower() {
    }

    public Borrower(String uniqueID, String fname, String lname, String business, String gender, String title, String mobile, String landphone, String email, String regdate, String address, String city, String province, String workstatus, String description, String files, User registeredby, MemberGroup group, List<Loan> borrowedLoans) {
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
        this.group = group;
        this.borrowedLoans = borrowedLoans;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public User getRegisteredby() {
        return registeredby;
    }

    public void setRegisteredby(User registeredby) {
        this.registeredby = registeredby;
    }

    public List<Loan> getBorrowedLoans() {
        return borrowedLoans;
    }

    public void setBorrowedLoans(List<Loan> borrowedLoans) {
        this.borrowedLoans = borrowedLoans;
    }

    public MemberGroup getGroup() {
        return group;
    }

    public void setGroup(MemberGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Borrower{");
        sb.append("bid=").append(bid);
        sb.append(", uniqueID='").append(uniqueID).append('\'');
        sb.append(", fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append(", business='").append(business).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", landphone='").append(landphone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", regdate='").append(regdate).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", workstatus='").append(workstatus).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", files='").append(files).append('\'');
        sb.append(", registeredby=").append(registeredby);
        sb.append(", group=").append(group);
        sb.append(", borrowedLoans=").append(borrowedLoans);
        sb.append('}');
        return sb.toString();
    }
}
