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
import model.Category;

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

    // Test
    public static void main(String[] args) throws SQLException {
        CategoryDAO categoryDAO = new CategoryDAO();
//        for (Category ds : categoryDAO.getListCategory()) {
//            System.out.println(ds.toString());
//        }
        System.out.println(categoryDAO.getCategoryByID(1).toString());
    }
}
