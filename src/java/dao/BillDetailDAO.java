/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BillDetail;

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
    
    public static void main(String[] args){
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        billDetailDAO.insertBillDetail(new BillDetail(0,1,2,3,4));
    }
}
