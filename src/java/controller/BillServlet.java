/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.DBConnect;
import dao.BillDAO;
import dao.BillDetailDAO;
import dao.SendMailDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.CartItem;
import model.Product;
import model.Users;

/**
 *
 * @author HuyBin
 */
public class BillServlet extends HttpServlet {

    BillDAO billDAO = new BillDAO();
    BillDetailDAO billDetailDAO = new BillDetailDAO();
    SendMailDAO sendMailDAO = new SendMailDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Param
        String command = request.getParameter("command");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        int billID = Integer.parseInt(request.getParameter("billID"));

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            user = new Users();
            session.setAttribute("user", user);
        }

        try {
            switch (command) {
                case "insert":
                    // insert bill
                    if (insertBillFromCart(cart, address, email, phonenumber, user.getUserID(), request)) {
                        // Clear cart
                        cart = new Cart();
                        session.setAttribute("cart", cart);
                        response.getWriter().write("success");

                    }
                    break;
                case "remove":
                    // remove bill
                    if(removeBill(billID)){
                        response.getWriter().write("success");
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("error");
        }
    }

    private boolean insertBillFromCart(Cart cart, String address, String email, String phonenumber, int userID, HttpServletRequest request) throws SQLException, IOException {
        Instant now = Instant.now();
        int id = (int) now.getEpochSecond();
        // Create mobel data
        Bill b = new Bill();
        b.setBillID(id);
        b.setBillAddress(address);
        b.setBillEmail(email);
        b.setBillPhonenumber(phonenumber);
        b.setBillTotal(cart.getTotalCart());
        b.setBillStatus(0);
        b.setBillOrderDate(Date.valueOf(LocalDate.now()));
        b.setUserID(userID);

        // Send mail
        sendMailDAO.sendMail(email, b, request);

        Connection connection = DBConnect.getConnection();
        connection.setAutoCommit(false);

        //Proccesing
        try {
            if (billDAO.insertBill(b)) {
                // Insert bill detail
                if (insertBillDetail(cart, b)) {
                    return true;
                }
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
        connection.close();
        return false;
    }

    private boolean insertBillDetail(Cart cart, Bill b) {
        boolean result = false;
        for (CartItem c : cart.getCart()) {
            // Create model data
            BillDetail bd = new BillDetail();
            bd.setBillID(b.getBillID());
            bd.setBillQuantity(c.getQuantity());
            bd.setBillPrice(c.getQuantity() * c.getProduct().getProductPrice());
            bd.setProductID(c.getProduct().getProductID());

            // Proccessing
            result = billDetailDAO.insertBillDetail(bd);
            if (result == false) {
                break;
            }
        }
        return result;
    }

    private boolean removeBill(int billID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        connection.setAutoCommit(false);

        //Proccesing
        try {
            if (billDAO.deleteBill(billID)) {
                // Insert bill detail
                if (billDetailDAO.deleteBillDetail(billID)) {
                    return true;
                }
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
        connection.close();
        return false;
    }
}
