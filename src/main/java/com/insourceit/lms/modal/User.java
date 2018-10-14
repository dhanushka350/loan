package com.insourceit.lms.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 6932867871030021038L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_mobile")
    private String contact;

    @Column(name = "user_last_login")
    private String last_login;

    @Column(name = "user_last_logout")
    private String last_logout;

    @Column(name = "user_status")
    private String active;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role")
    private Role role;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registeredby", fetch = FetchType.LAZY)
    private List<Borrower> borrowers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addedOfficer", fetch = FetchType.LAZY)
    private List<Loan> addedList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "primaryApprovalOfficer", fetch = FetchType.LAZY)
    private List<Loan> PrimaryApprovalList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secondaryApprovalOfficer", fetch = FetchType.LAZY)
    private List<Loan> secondaryApprovalList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanReleaseOfficer", fetch = FetchType.LAZY)
    private List<Loan> releasedList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regby", fetch = FetchType.LAZY)
    private List<MemberGroup> registerdGroup = new ArrayList<>();

    public User() {
    }

    public User(String name, String password, String contact, String last_login, String last_logout, String active, Role role, List<Borrower> borrowers, List<Loan> addedList, List<Loan> primaryApprovalList, List<Loan> secondaryApprovalList, List<Loan> releasedList, List<MemberGroup> registerdGroup) {
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.last_login = last_login;
        this.last_logout = last_logout;
        this.active = active;
        this.role = role;
        this.borrowers = borrowers;
        this.addedList = addedList;
        PrimaryApprovalList = primaryApprovalList;
        this.secondaryApprovalList = secondaryApprovalList;
        this.releasedList = releasedList;
        this.registerdGroup = registerdGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLast_logout() {
        return last_logout;
    }

    public void setLast_logout(String last_logout) {
        this.last_logout = last_logout;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public List<Loan> getAddedList() {
        return addedList;
    }

    public void setAddedList(List<Loan> addedList) {
        this.addedList = addedList;
    }

    public List<Loan> getPrimaryApprovalList() {
        return PrimaryApprovalList;
    }

    public void setPrimaryApprovalList(List<Loan> primaryApprovalList) {
        PrimaryApprovalList = primaryApprovalList;
    }

    public List<Loan> getSecondaryApprovalList() {
        return secondaryApprovalList;
    }

    public void setSecondaryApprovalList(List<Loan> secondaryApprovalList) {
        this.secondaryApprovalList = secondaryApprovalList;
    }

    public List<Loan> getReleasedList() {
        return releasedList;
    }

    public void setReleasedList(List<Loan> releasedList) {
        this.releasedList = releasedList;
    }

    public List<MemberGroup> getRegisterdGroup() {
        return registerdGroup;
    }

    public void setRegisterdGroup(List<MemberGroup> registerdGroup) {
        this.registerdGroup = registerdGroup;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", last_login='").append(last_login).append('\'');
        sb.append(", last_logout='").append(last_logout).append('\'');
        sb.append(", active='").append(active).append('\'');
        sb.append(", role=").append(role);
        sb.append(", borrowers=").append(borrowers);
        sb.append(", addedList=").append(addedList);
        sb.append(", PrimaryApprovalList=").append(PrimaryApprovalList);
        sb.append(", secondaryApprovalList=").append(secondaryApprovalList);
        sb.append(", releasedList=").append(releasedList);
        sb.append(", registerdGroup=").append(registerdGroup);
        sb.append('}');
        return sb.toString();
    }
}
