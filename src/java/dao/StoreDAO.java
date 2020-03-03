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
import model.Stores;

/**
 *
 * @author HuyBin
 */
public class StoreDAO {

    public ArrayList<Stores> getListStores(int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Stores> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay ORDER BY NgayCapNhat DESC LIMIT 0," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Stores s = new Stores();
                s.setStoreID(rs.getInt("MaCH"));
                s.setStoreName(rs.getString("TenCH"));
                s.setStoreAdress(rs.getString("DiaChiCH"));
                s.setStoreDescription(rs.getString("MoTaCH"));
                s.setStorePhonenumber(rs.getString("SoDienThoaiCH"));
                s.setStoreName(rs.getString("EmailCH"));

                // Add to the result
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }
    
    public boolean deleteStores(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM cuahang WHERE MaCH=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }

    public boolean insertStores(Stores s) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO cuahang (TenCH, DiaChiCH, MoTaCH, SoDienThoaiCH, EmailCH) VALUES(?,?,?,?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, s.getStoreName());
            ps.setString(2, s.getStoreAdress());
            ps.setString(3, s.getStoreDescription());
            ps.setString(4, s.getStorePhonenumber());
            ps.setString(5, s.getStoreEmail());

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

    public boolean updateStores(Stores s) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "UPDATE cuahang SET TenCH=?, DiaChiCH=?, MoTaCH=?, SoDienThoaiCH=?, EmailCH=? WHERE MaCH=?";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, s.getStoreName());
            ps.setString(2, s.getStoreAdress());
            ps.setString(3, s.getStoreDescription());
            ps.setString(4, s.getStorePhonenumber());
            ps.setString(5, s.getStoreEmail());
            ps.setInt(6, s.getStoreID());

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
}
