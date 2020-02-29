/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author HuyBin
 */
public class Product {

    private int productID;
    private int categoryID;
    private int producerID;
    private String productName;
    private String productTitle;
    private String productDescription;
    private String productSize;
    private String productColor;
    private String productImage;
    private int productPrice;
    private Date updateDate;
    private int quantitySold;
    private int inventoryNumber;

    public Product(int productID, int categoryID, int producerID, String productName, String productTitle, String productDescription, String productSize, String productColor, String productImage, int productPrice, Date updateDate, int quantitySold, int inventoryNumber) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.producerID = producerID;
        this.productName = productName;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productSize = productSize;
        this.productColor = productColor;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.updateDate = updateDate;
        this.quantitySold = quantitySold;
        this.inventoryNumber = inventoryNumber;
    }

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
    
    

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", categoryID=" + categoryID + ", producerID=" + producerID + ", productName=" + productName + ", productTitle=" + productTitle + ", productDescription=" + productDescription + ", productSize=" + productSize + ", productColor=" + productColor + ", productImage=" + productImage + ", productPrice=" + productPrice + ", updateDate=" + updateDate + ", quantitySold=" + quantitySold + ", inventoryNumber=" + inventoryNumber + '}';
    }

}
