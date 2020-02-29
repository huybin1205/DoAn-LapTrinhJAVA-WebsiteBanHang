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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Banner;
import model.Users;

/**
 *
 * @author HuyBin
 */
public class UserDAO {

    public boolean checkAccount(String username) {
        // Connect to database
        Connection connection = DBConnect.getConnection();
        // String query
        String sql = "SELECT * FROM khachhang WHERE Taikhoan = '" + username + "'";
        // Processing query
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // available
                connection.close();
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //non-available
        return false;
    }

    public boolean insertUser(Users u) {
        try {
            // Connect to database
            Connection connection = DBConnect.getConnection();
            // String query
            String sql = "INSERT INTO khachhang (HoTen, Email, DiachiKH, DienthoaiKH, Ngaysinh, Taikhoan, Matkhau) VALUES(?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'),?,?)";
            // Processing query
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, u.getUserEmail());
            ps.setString(2, u.getUserEmail());
            ps.setString(3, u.getUserAddress());
            ps.setString(4, u.getUserPhonenumber());
            ps.setDate(5, u.getUserDateOfBirth());
            ps.setString(6, u.getUserAccount());
            ps.setString(7, u.getUserPassword());
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

    public Users login(String email, String password) {
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM khachhang WHERE Taikhoan='" + email + "' and Matkhau ='" + password + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Users u = new Users();
                u.setUserID(rs.getInt("MaKH"));
                u.setUserName(rs.getString("HoTen"));
                u.setUserEmail(rs.getString("Email"));
                u.setUserAddress(rs.getString("DiachiKH"));
                u.setUserPhonenumber(rs.getString("DienthoaiKH"));
                u.setUserDateOfBirth(rs.getDate("Ngaysinh"));
                u.setUserAccount(rs.getString("Taikhoan"));
                u.setUserPassword(rs.getString("Matkhau"));

                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
