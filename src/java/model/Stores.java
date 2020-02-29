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
public class Stores {
    private int storeID;
    private String storeName;
    private String storeAdress;
    private String storeDescription;
    private String storePhonenumber;
    private String storeEmail;

    public Stores() {
    }

    public Stores(int storeID, String storeName, String storeAdress, String storeDescription, String storePhonenumber, String storeEmail) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeAdress = storeAdress;
        this.storeDescription = storeDescription;
        this.storePhonenumber = storePhonenumber;
        this.storeEmail = storeEmail;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAdress() {
        return storeAdress;
    }

    public void setStoreAdress(String storeAdress) {
        this.storeAdress = storeAdress;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getStorePhonenumber() {
        return storePhonenumber;
    }

    public void setStorePhonenumber(String storePhonenumber) {
        this.storePhonenumber = storePhonenumber;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    @Override
    public String toString() {
        return "Stores{" + "storeID=" + storeID + ", storeName=" + storeName + ", storeAdress=" + storeAdress + ", storeDescription=" + storeDescription + ", storePhonenumber=" + storePhonenumber + ", storeEmail=" + storeEmail + '}';
    }
    
}
