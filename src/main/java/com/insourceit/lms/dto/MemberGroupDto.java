package com.insourceit.lms.dto;

public class MemberGroupDto {
    private int mgid;
    private String name;
    private String area;
    private int memberCount;
    private String collector;
    private String collectionDay;
    private String description;
    private String regBy;
    private String status;
    private String regDate;

    public MemberGroupDto() {
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegBy() {
        return regBy;
    }

    public void setRegBy(String regBy) {
        this.regBy = regBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMGID() {
        return mgid;
    }

    public void setMGID(int MGID) {
        this.mgid = MGID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
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
}
