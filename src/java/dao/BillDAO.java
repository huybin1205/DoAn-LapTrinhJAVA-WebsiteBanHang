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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.Product;

/**
 *
 * @author HuyBin
 */
public class BillDAO {

    public boolean insertBill(Bill bill) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO dondathang (MaDonHang, DiaChi, Email, SoDienThoai, TongTien, TinhTrangDonHang, NgayDat, MaKH) VALUES(?,?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, bill.getBillID());
            ps.setString(2, bill.getBillAddress());
            ps.setString(3, bill.getBillEmail());
            ps.setString(4, bill.getBillPhonenumber());
            ps.setInt(5, bill.getBillTotal());
            ps.setInt(6, bill.getBillStatus());
            ps.setDate(7, bill.getBillOrderDate());
            ps.setInt(8, bill.getUserID());
            ps.executeUpdate();
//            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        // Return
        return false;
    }

    public ArrayList<Bill> getAllBill() throws SQLException {
        // Create an array save the result
        ArrayList<Bill> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM dondathang";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Bill b = new Bill();
                b.setBillID(rs.getInt("MaDonHang"));
                b.setBillAddress(rs.getString("DiaChi"));
                b.setBillEmail(rs.getString("Email"));
                b.setBillPhonenumber(rs.getString("SoDienThoai"));
                b.setBillTotal(rs.getInt("TongTien"));
                b.setBillStatus(rs.getInt("TinhTrangDonHang"));
                b.setBillOrderDate(rs.getDate("NgayDat"));
                b.setUserID(rs.getInt("MaKH"));

                // Add to the result
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }

    public Bill getBill(int id) throws SQLException {
        // Create a object save the result

        Bill b = new Bill();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM dondathang WHERE MaDonHang=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            // Save data from the database
            b.setBillID(rs.getInt("MaDonHang"));
            b.setBillAddress(rs.getString("DiaChi"));
            b.setBillEmail(rs.getString("Email"));
            b.setBillPhonenumber(rs.getString("SoDienThoai"));
            b.setBillTotal(rs.getInt("TongTien"));
            b.setBillStatus(rs.getInt("TinhTrangDonHang"));
            b.setBillOrderDate(rs.getDate("NgayDat"));
            b.setUserID(rs.getInt("MaKH"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return
        return b;
    }

    public ArrayList<Bill> getAllBill(int pages) throws SQLException {
        // Create an array save the result
        ArrayList<Bill> list = new ArrayList<>();
        try {
            // Declare
            int totalRecords = this.getAllBill().size();
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
            String sql = "SELECT * FROM dondathang LIMIT " + start + "," + recordsPerPage;
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // Loop data from the database
            while (rs.next()) {
                // Create a model to save data from the database
                Bill b = new Bill();
                b.setBillID(rs.getInt("MaDonHang"));
                b.setBillAddress(rs.getString("DiaChi"));
                b.setBillEmail(rs.getString("Email"));
                b.setBillPhonenumber(rs.getString("SoDienThoai"));
                b.setBillTotal(rs.getInt("TongTien"));
                b.setBillStatus(rs.getInt("TinhTrangDonHang"));
                b.setBillOrderDate(rs.getDate("NgayDat"));
                b.setUserID(rs.getInt("MaKH"));

                // Add to the result
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }
    
    public boolean deleteBill(int id) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM dondathang WHERE MaDonHang=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }

    public static void main(String[] args) {
        BillDAO billDAO = new BillDAO();
        billDAO.insertBill(new Bill(1, "Quận 12", "huy@123.com", "0123", 1200000, 1, Date.valueOf(LocalDate.now()), 1));
    }
}
