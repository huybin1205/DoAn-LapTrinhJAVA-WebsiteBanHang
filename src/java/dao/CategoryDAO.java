/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

/**
 *
 * @author HuyBin
 */
public class CategoryDAO {

    // get list category
    public ArrayList<Category> getListCategory() throws SQLException {
        // Connect to database
        Connection connection = DBConnect.getConnection();
        // String query
        String sql = "SELECT * FROM danhmuc";
        // Processing query
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        // Create an array save the result
        ArrayList<Category> list = new ArrayList<>();
        // Loop data from the database
        while (rs.next()) {

            Category category = new Category();
            category.setCategoryId(rs.getInt("MaDM"));
            category.setCategoryName(rs.getString("TenDM"));

            // Add to the result
            list.add(category);
        }

        // Return
        return list;
    }

    public Category getCategoryByID(int id) {
        Category c = new Category();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM danhmuc WHERE MADM=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            // data from the database
            c = new Category();
            c.setCategoryId(rs.getInt("MaDM"));
            c.setCategoryName(rs.getString("TenDM"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return c;
    }
    
    public boolean insertCategory(Category c) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO danhmuc (TenDM, Images) VALUES(?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, c.getCategoryName());
            ps.setString(2, c.getCategoryImage());
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
    
    public boolean updateCategory(Category c) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "UPDATE danhmuc SET TenDM=?, Images=? WHERE MaDM = ?";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, c.getCategoryName());
            ps.setString(2, c.getCategoryImage());
            ps.setInt(3, c.getCategoryId());
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
    
    public boolean deleteCategory(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM danhmuc WHERE MaDM=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }

    // Test
    public static void main(String[] args) throws SQLException {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category c=  new Category();
        c.setCategoryName("Đồng hồ");
        c.setCategoryImage("");
        categoryDAO.updateCategory(c);
//        System.out.println(categoryDAO.getCategoryByID(1).toString());
    }
}
