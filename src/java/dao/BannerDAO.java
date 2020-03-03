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
import model.Banner;
import model.Producer;
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

    public boolean deleteBanner(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM banner WHERE MaBanner=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }

    public boolean insertBanner(Banner b) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO cuahang (TenBanner, MoTaBanner, Images, Link) VALUES(?,?,?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, b.getBannerName());
            ps.setString(2, b.getBannerDescription());
            ps.setString(3, b.getBannerImage());
            ps.setString(4, b.getBannerLink());

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

    public boolean updateProducer(Banner b) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "UPDATE banner SET TenBanner=?, MoTaBanner=?, Images=?, Link=? WHERE MaBanner=?";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, b.getBannerName());
            ps.setString(2, b.getBannerDescription());
            ps.setString(3, b.getBannerImage());
            ps.setString(4, b.getBannerLink());
            ps.setInt(5, b.getBannerID());

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

    public static void main(String[] args) throws SQLException {
        BannerDAO bannerDAO = new BannerDAO();
//        System.out.println(bannerDAO.getBanner(3).toString());
    }
}
