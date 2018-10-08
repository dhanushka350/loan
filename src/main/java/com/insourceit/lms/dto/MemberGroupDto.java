package com.insourceit.lms.dto;

public class MemberGroupDto {
    private int MGID;
    private String name;
    private String area;
    private int memberCount;
    private String collector;
    private String collectionDay;
    private String description;

    public MemberGroupDto() {
    }

    public int getMGID() {
        return MGID;
    }

    public void setMGID(int MGID) {
        this.MGID = MGID;
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
