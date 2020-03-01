/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import constants.Constants;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Users;

/**
 *
 * @author HuyBin
 */
public class ProductDAO {

    // get product by category
    public ArrayList<Product> getProductByCategory(int category) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay WHERE MaDM = " + category;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;

    }

    public ArrayList<Product> getProductByCategory(int category, int pages) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Declare
            int totalRecords = this.getProductByCategory(category).size();
            int recordsPerPage = Constants.RECORDS_PER_PAGE;
            int totalPage = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            // Check page current
            if (pages > totalPage) {
                pages = (int) totalPage;
            } else if (pages < 1) {
                pages = 1;
            }
            // Posotion Start
            int start = (pages - 1) * recordsPerPage;
            // String query
            String sql = "SELECT * FROM giay WHERE MaDM = " + category + " LIMIT " + start + "," + recordsPerPage;
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return
        return list;
    }

    public Product getProduct(int id) throws SQLException {
        // Create a object save the result

        Product p = new Product();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay WHERE MaGiay=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            // Save data from the database
            p.setProductID(rs.getInt("MaGiay"));
            p.setCategoryID(rs.getInt("MaDM"));
            p.setProducerID(rs.getInt("MaNSX"));
            p.setProductName(rs.getString("TenGiay"));
            p.setProductTitle(rs.getString("TieuDe"));
            p.setProductDescription(rs.getString("Mota"));
            p.setProductSize(rs.getString("Size"));
            p.setProductColor(rs.getString("Mau"));
            p.setProductImage(rs.getString("Anhbia"));
            p.setProductPrice(rs.getInt("Giaban"));
            p.setUpdateDate(rs.getDate("NgayCapNhat"));
            p.setQuantitySold(rs.getInt("SoLuongBan"));
            p.setInventoryNumber(rs.getInt("SoLuongTon"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return
        return p;
    }

    public ArrayList<Product> getAllProduct() throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getAllProduct(int pages) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Declare
            int totalRecords = this.getAllProduct().size();
            int recordsPerPage = Constants.RECORDS_PER_PAGE;
            int totalPage = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            // Check page current
            if (pages > totalPage) {
                pages = (int) totalPage;
            } else if (pages < 1) {
                pages = 1;
            }
            // Posotion Start
            int start = (pages - 1) * recordsPerPage;
            // String query
            String sql = "SELECT * FROM giay LIMIT " + start + "," + recordsPerPage;
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getNewProduct(int category, int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay WHERE MaDM = " + category + " ORDER BY NgayCapNhat DESC LIMIT 0," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getNewProduct(int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
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
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getBestSaleProduct(int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay ORDER BY SoLuongBan DESC LIMIT 0," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getRelateProduct(int categoryID, int productID, int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM giay WHERE MaDM = " + categoryID + " and MaGiay NOT IN (" + productID + ") ORDER BY NgayCapNhat DESC LIMIT 0," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public ArrayList<Product> getRandomProduct(int quantity) throws SQLException {
        // Create an array save the result
        ArrayList<Product> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // Random
            Random rd = new Random();
            int random = rd.nextInt(this.getAllProduct().size() - quantity);
            if (random <= 0) {
                random = 0;
            }
            // String query
            String sql = "SELECT * FROM giay ORDER BY NgayCapNhat DESC LIMIT " + random + "," + quantity;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Product p = new Product();
                p.setProductID(rs.getInt("MaGiay"));
                p.setCategoryID(rs.getInt("MaDM"));
                p.setProducerID(rs.getInt("MaNSX"));
                p.setProductName(rs.getString("TenGiay"));
                p.setProductTitle(rs.getString("TieuDe"));
                p.setProductDescription(rs.getString("Mota"));
                p.setProductSize(rs.getString("Size"));
                p.setProductColor(rs.getString("Mau"));
                p.setProductImage(rs.getString("Anhbia"));
                p.setProductPrice(rs.getInt("Giaban"));
                p.setUpdateDate(rs.getDate("NgayCapNhat"));
                p.setQuantitySold(rs.getInt("SoLuongBan"));
                p.setInventoryNumber(rs.getInt("SoLuongTon"));

                // Add to the result
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public boolean deleteProduct(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM giay WHERE MaGiay=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }

    public boolean insertProduct(Product p) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO giay (MaDM, MaNSX, TenGiay, TieuDe, Mota, Size, Mau, Anhbia, Giaban, NgayCapNhat, SoLuongBan, SoLuongTon) VALUES(?,?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, p.getCategoryID());
            ps.setInt(2, p.getProducerID());
            ps.setString(3, p.getProductName());
            ps.setString(4, p.getProductTitle());
            ps.setString(5, p.getProductDescription());
            ps.setString(6, p.getProductSize());
            ps.setString(7, p.getProductColor());
            ps.setString(8, p.getProductImage());
            ps.setInt(9, p.getProductPrice());
            ps.setDate(10, (Date) p.getUpdateDate());
            ps.setInt(11, p.getQuantitySold());
            ps.setInt(12, p.getInventoryNumber());
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
    
    public boolean updateProduct(Product p) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "UPDATE giay SET MaDM=?, MaNSX=?, TenGiay=?, TieuDe=?, Mota=?, Size=?, Mau=?, Anhbia=?, Giaban=?, NgayCapNhat=STR_TO_DATE(?,'%Y-%m-%d'), SoLuongBan=?, SoLuongTon=? WHERE MaGiay=?";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, p.getCategoryID());
            ps.setInt(2, p.getProducerID());
            ps.setString(3, p.getProductName());
            ps.setString(4, p.getProductTitle());
            ps.setString(5, p.getProductDescription());
            ps.setString(6, p.getProductSize());
            ps.setString(7, p.getProductColor());
            ps.setString(8, p.getProductImage());
            ps.setInt(9, p.getProductPrice());
            ps.setDate(10, (Date) p.getUpdateDate());
            ps.setInt(11, p.getQuantitySold());
            ps.setInt(12, p.getInventoryNumber());
            ps.setInt(13, p.getProductID());
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

    // Test
    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        boolean isUpdate = productDAO.updateProduct(new Product(126,1,1,"name","title","description","M","Red","/image/",11111,Date.valueOf(LocalDate.now()),1,1));
        System.out.println(isUpdate);
    }
}
