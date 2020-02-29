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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

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
    
    public static void main(String[] args){
        BillDAO billDAO = new BillDAO();
        billDAO.insertBill(new Bill(1,"Quận 12","huy@123.com","0123",1200000,1,Date.valueOf(LocalDate.now()),1));
    }
}
