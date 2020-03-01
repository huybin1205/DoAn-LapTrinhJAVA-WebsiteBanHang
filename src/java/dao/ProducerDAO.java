/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Producer;

/**
 *
 * @author HuyBin
 */
public class ProducerDAO {

    // get product by category
    public ArrayList<Producer> getAllProducer() throws SQLException {
        // Create an array save the result
        ArrayList<Producer> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM nhasanxuat";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Producer p = new Producer();
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProducerName(rs.getString("TenNSX"));
                p.setProducerAddress(rs.getString("Diachi"));
                p.setProducerPhonenumber(rs.getString("DienThoai"));
                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }
    
    public static void main(String[] args) throws SQLException{
        ProducerDAO producerDAO = new  ProducerDAO();
        
        for(Producer p :producerDAO.getAllProducer()){
            System.out.println(p.toString());
        }
    }
}
