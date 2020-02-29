/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.DBConnect;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HuyBin
 */
public class ProductServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

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
        int productID = -1;
        if (request.getParameter("productID") == null && request.getParameter("command") == null) {
            return;
        }
        productID = Integer.parseInt(request.getParameter("productID"));
        String command = request.getParameter("command");

        switch (command) {
            case "remove":
                try {
                    if (removeProduct(productID)) {
                        response.getWriter().write(constants.Constants.SUCCESS);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.getWriter().write(constants.Constants.ERROR);
                break;
        }
    }

    private boolean removeProduct(int productID) throws SQLException {
        Connection c = DBConnect.getConnection();
        c.setAutoCommit(false);
        try {
            if (productDAO.deleteProduct(productID)) {
                c.commit();
                return true;
            }
        } catch (SQLException ex) {
            c.rollback();
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.rollback();
        c.close();
        return false;
    }

}
