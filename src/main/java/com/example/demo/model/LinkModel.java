package com.example.demo.model;

public class LinkModel {
    private int linkId;
    private String linkName;
    private String linkURL;
    private double linkPrice;
    private int linkType;

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
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

    public double getLinkPrice() {
        return linkPrice;
    }

    public void setLinkPrice(double linkPrice) {
        this.linkPrice = linkPrice;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }
}
