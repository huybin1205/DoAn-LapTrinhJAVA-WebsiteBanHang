/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HuyBin
 */
public class Banner {
    private int bannerID;
    private String bannerName;
    private String bannerDescription;
    private String bannerImage;
    private String bannerLink;

    public Banner(int bannerID, String bannerName, String bannerDescription, String bannerImage, String bannerLink) {
        this.bannerID = bannerID;
        this.bannerName = bannerName;
        this.bannerDescription = bannerDescription;
        this.bannerImage = bannerImage;
        this.bannerLink = bannerLink;
    }

    public Banner() {
    }

    public int getBannerID() {
        return bannerID;
    }

    public void setBannerID(int bannerID) {
        this.bannerID = bannerID;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerDescription() {
        return bannerDescription;
    }

    public void setBannerDescription(String bannerDescription) {
        this.bannerDescription = bannerDescription;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerLink() {
        return bannerLink;
    }

    public void setBannerLink(String bannerLink) {
        this.bannerLink = bannerLink;
    }

    @Override
    public String toString() {
        return "Banner{" + "bannerID=" + bannerID + ", bannerName=" + bannerName + ", bannerDescription=" + bannerDescription + ", bannerImage=" + bannerImage + ", bannerLink=" + bannerLink + '}';
    }
}
