package com.insourceit.lms.modal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_member_group")
public class MemberGroup implements Serializable {

    private static final long serialVersionUID = -2964781139401202771L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idt_member_group")
    private int MGID;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private String area;

    @Column(name = "member_count")
    private int memberCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_by")
    private User regby;

    @Column(name = "status")
    private String status;

    @Column(name = "collection_day")
    private String collectionDay;

    @Column(name = "description")
    private String description;

    @Column(name = "reg_date")
    private String rergDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.LAZY)
    private List<Borrower> borrowers = new ArrayList<>();

    public MemberGroup() {
    }

    public MemberGroup(String name, String area, int memberCount, User user, User regby, String status, String collectionDay, String description, String rergDate, List<Borrower> borrowers) {
        this.name = name;
        this.area = area;
        this.memberCount = memberCount;
        this.user = user;
        this.regby = regby;
        this.status = status;
        this.collectionDay = collectionDay;
        this.description = description;
        this.rergDate = rergDate;
        this.borrowers = borrowers;
    }

    public User getRegby() {
        return regby;
    }

    public void setRegby(User regby) {
        this.regby = regby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMGID() {
        return MGID;
    }

    public void setMGID(int MGID) {
        this.MGID = MGID;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCollectionDay() {
        return collectionDay;
    }

    public void setCollectionDay(String collectionDay) {
        this.collectionDay = collectionDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRergDate() {
        return rergDate;
    }

    public void setRergDate(String rergDate) {
        this.rergDate = rergDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MemberGroup{");
        sb.append("MGID=").append(MGID);
        sb.append(", name='").append(name).append('\'');
        sb.append(", area='").append(area).append('\'');
        sb.append(", memberCount=").append(memberCount);
        sb.append(", user=").append(user);
        sb.append(", regby=").append(regby);
        sb.append(", status='").append(status).append('\'');
        sb.append(", collectionDay='").append(collectionDay).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", rergDate='").append(rergDate).append('\'');
        sb.append(", borrowers=").append(borrowers);
        sb.append('}');
        return sb.toString();
    }
}
