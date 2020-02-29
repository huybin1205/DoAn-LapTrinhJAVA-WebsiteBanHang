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
public class Bill {
    private int billID;
    private String billAddress;
    private String billEmail;
    private String billPhonenumber;
    private int billTotal;
    private int billStatus;
    private Date billOrderDate;
    private int userID;

    public Bill() {
    }

    public Bill(int billID, String billAddress, String billEmail, String billPhonenumber, int billTotal, int billStatus, Date billOrderDate, int userID) {
        this.billID = billID;
        this.billAddress = billAddress;
        this.billEmail = billEmail;
        this.billPhonenumber = billPhonenumber;
        this.billTotal = billTotal;
        this.billStatus = billStatus;
        this.billOrderDate = billOrderDate;
        this.userID = userID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String billEmail) {
        this.billEmail = billEmail;
    }

    public String getBillPhonenumber() {
        return billPhonenumber;
    }

    public void setBillPhonenumber(String billPhonenumber) {
        this.billPhonenumber = billPhonenumber;
    }

    public int getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(int billTotal) {
        this.billTotal = billTotal;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public Date getBillOrderDate() {
        return billOrderDate;
    }

    public void setBillOrderDate(Date billOrderDate) {
        this.billOrderDate = billOrderDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", billAddress=" + billAddress + ", billEmail=" + billEmail + ", billPhonenumber=" + billPhonenumber + ", billTotal=" + billTotal + ", billStatus=" + billStatus + ", billOrderDate=" + billOrderDate + ", userID=" + userID + '}';
    }
}
