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
            String sql = "SELECT * FROM giay ORDER BY NgayCapNhat DESC LIMIT 0,"+quantity;
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
}
