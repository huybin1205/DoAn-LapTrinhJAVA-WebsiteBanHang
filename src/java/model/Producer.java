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
public class Producer {
    private int producerID;
    private String producerName;
    private String producerAddress;
    private String producerPhonenumber;

    public Producer() {
    }

    public Producer(int producerID, String producerName, String producerAddress, String producerPhonenumber) {
        this.producerID = producerID;
        this.producerName = producerName;
        this.producerAddress = producerAddress;
        this.producerPhonenumber = producerPhonenumber;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public String getProducerPhonenumber() {
        return producerPhonenumber;
    }

    public void setProducerPhonenumber(String producerPhonenumber) {
        this.producerPhonenumber = producerPhonenumber;
    }

    @Override
    public String toString() {
        return "Producer{" + "producerID=" + producerID + ", producerName=" + producerName + ", producerAddress=" + producerAddress + ", producerPhonenumber=" + producerPhonenumber + '}';
    }
    
    
}
