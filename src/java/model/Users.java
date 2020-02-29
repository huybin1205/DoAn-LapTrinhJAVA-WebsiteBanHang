/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HuyBin
 */
public class Users {
    private int userID;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userPhonenumber;
    private Date userDateOfBirth;
    private String userAccount;
    private String userPassword;

    public Users(int userID, String userName, String userEmail, String userAddress, String userPhonenumber, Date userDateOfBirth, String userAccount, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPhonenumber = userPhonenumber;
        this.userDateOfBirth = userDateOfBirth;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    public Users() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Users{" + "userID=" + userID + ", userName=" + userName + ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userPhonenumber=" + userPhonenumber + ", userDateOfBirth=" + userDateOfBirth + ", userAccount=" + userAccount + ", userPassword=" + userPassword + '}';
    }
}
