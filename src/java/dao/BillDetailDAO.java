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
import model.BillDetail;
import model.Category;

/**
 *
 * @author HuyBin
 */
public class BillDetailDAO {
     public boolean insertBillDetail(BillDetail b) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO chitietdonhang (MaDonHang, MaGiay, Soluong, DonGia) VALUES(?,?,?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, b.getBillID());
            ps.setInt(2, b.getProductID());
            ps.setInt(3, b.getBillQuantity());
            ps.setInt(4, b.getBillPrice());
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
     
     public ArrayList<BillDetail> getListBillDetailByID(int id) {
        ArrayList<BillDetail> list = new ArrayList<>();
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "SELECT * FROM chitietdonhang WHERE MaDonHang=" + id;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BillDetail b = new BillDetail();
                // data from the database
                b.setBillDetailID(rs.getInt("ID"));
                b.setBillID(rs.getInt("MaDonHang"));
                b.setProductID(rs.getInt("MaGiay"));
                b.setBillQuantity(rs.getInt("SoLuong"));
                b.setBillPrice(rs.getInt("DonGia"));
                
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return
        return list;
    }
     
    public boolean deleteBillDetail(int BillId) throws SQLException {
        // Create an variable save the result
        boolean result = false;
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "DELETE FROM chitietdonhang WHERE MaDonHang=" + BillId;
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            result = ps.executeUpdate() > 0;
        } catch (Exception e) {
            result = false;
        }
        // Return
        return result;
    }
    
    public static void main(String[] args){
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        billDetailDAO.insertBillDetail(new BillDetail(0,1,2,3,4));
    }
}
