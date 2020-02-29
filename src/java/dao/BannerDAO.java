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
import model.Banner;
import model.Product;

/**
 *
 * @author HuyBin
 */
public class BannerDAO {

    public ArrayList<Banner> getBanner(int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Banner> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM banner ORDER BY MaBanner DESC LIMIT 0," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Banner b = new Banner();
                b.setBannerID(rs.getInt("MaBanner"));
                b.setBannerName(rs.getString("TenBanner"));
                b.setBannerDescription(rs.getString("MoTaBanner"));
                b.setBannerImage(rs.getString("Images"));
                b.setBannerLink(rs.getString("Link"));
                // Add to the result
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }
    
    public static void main(String[] args) throws SQLException{
        BannerDAO bannerDAO = new BannerDAO();
//        System.out.println(bannerDAO.getBanner(3).toString());
    }
}
