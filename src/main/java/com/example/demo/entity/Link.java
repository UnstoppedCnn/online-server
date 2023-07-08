package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Link {
    private Integer linkId;
    private String linkName;
    private String linkURL;
    private Timestamp linkPrice;
    private Timestamp endTime;
    private Integer linkType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")

    private Timestamp creationTime;

    @Override
    public String toString() {
        return "link{" +
                "linkId=" + linkId +
                ", linkName='" + linkName + '\'' +
                ", linkURL='" + linkURL + '\'' +
                ", linkPrice=" + linkPrice +
                ", endTime=" + endTime +
                ", linkType=" + linkType +
                ", creationTime=" + creationTime +
                '}';
    }

    public Link(Integer linkId, String linkName, String linkURL, Timestamp linkPrice, Timestamp endTime, Integer linkType, Timestamp creationTime) {
        this.linkId = linkId;
        this.linkName = linkName;
        this.linkURL = linkURL;
        this.linkPrice = linkPrice;
        this.endTime = endTime;
        this.linkType = linkType;
        this.creationTime = creationTime;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public Timestamp getLinkPrice() {
        return linkPrice;
    }

    public void setLinkPrice(Timestamp linkPrice) {
        this.linkPrice = linkPrice;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }
}
