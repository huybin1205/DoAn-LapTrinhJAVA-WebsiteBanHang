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
public class BillDetail {
    private int billDetailID;
    private int billID;
    private int productID;
    private int billQuantity;
    private int billPrice;

    public BillDetail() {
    }

    public BillDetail(int billDetailID, int billID, int productID, int billQuantity, int billPrice) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.productID = productID;
        this.billQuantity = billQuantity;
        this.billPrice = billPrice;
    }

    public int getBillDetailID() {
        return billDetailID;
    }

    public void setBillDetailID(int billDetailID) {
        this.billDetailID = billDetailID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getBillQuantity() {
        return billQuantity;
    }

    public void setBillQuantity(int billQuantity) {
        this.billQuantity = billQuantity;
    }

    public int getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(int billPrice) {
        this.billPrice = billPrice;
    }
    
    
}
