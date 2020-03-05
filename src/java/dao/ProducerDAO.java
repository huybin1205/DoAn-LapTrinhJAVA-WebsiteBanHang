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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public boolean deleteProducer(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM nhasanxuat WHERE MaNSX=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }
    
    public Producer getProducer(int id) throws SQLException {
        // Create a object save the result

        Producer p = new Producer();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM nhasanxuat WHERE MaNSX=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            // Save data from the database
            p.setProducerID(rs.getInt("MaNSX"));
            p.setProducerName(rs.getString("TenNSX"));
            p.setProducerAddress(rs.getString("Diachi"));
            p.setProducerPhonenumber(rs.getString("DienThoai"));
        }catch(SQLException e){
            e.printStackTrace();
        }

        // Return
        return p;
    }

    public boolean insertProducer(Producer p) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO nhasanxuat (TenNSX, Diachi, DienThoai) VALUES(?,?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, p.getProducerName());
            ps.setString(2, p.getProducerAddress());
            ps.setString(3, p.getProducerPhonenumber());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        // Return
        return false;
    }

    public boolean updateProducer(Producer p) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "UPDATE nhasanxuat SET TenNSX=?, Diachi=?, DienThoai=? WHERE MaNSX=?";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, p.getProducerName());
            ps.setString(2, p.getProducerAddress());
            ps.setString(3, p.getProducerPhonenumber());
            ps.setInt(4, p.getProducerID());

            ps.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        // Return
        return false;
    }
    
    public static void main(String[] args) throws SQLException{
        ProducerDAO producerDAO = new  ProducerDAO();
        
        for(Producer p :producerDAO.getAllProducer()){
            System.out.println(p.toString());
        }
    }
}
