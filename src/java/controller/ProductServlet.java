/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.DBConnect;
import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

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
        String url = "";
        RequestDispatcher rd;

        if (request.getParameter("command").compareTo("") == 0 || request.getParameter("command") == null) {
            url = "/admin/products-detail.jsp";
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        }

        String command = request.getParameter("command");

        switch (command) {
            case "remove":
                int productID = -1;
                if (request.getParameter("productID") != null) {
                    productID = Integer.parseInt(request.getParameter("productID"));

                    try {
                        if (removeProduct(productID)) {
                            response.getWriter().write(constants.Constants.SUCCESS);
                            return;
//                            break;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.getWriter().write(constants.Constants.ERROR);
                break;
            case "insert":
                try {
                    if (insertProduct(request)) {
                        url = "/admin/products.jsp";
                        rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);
                    } else {
                        url = request.getRequestURI();
                        rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    private boolean insertProduct(HttpServletRequest request) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            Product p = new Product();
            p.setCategoryID(Integer.parseInt(request.getParameter("categoryID")));
            p.setProducerID(Integer.parseInt(request.getParameter("producerID")));
            p.setProductName(request.getParameter("productName"));
            p.setProductDescription(request.getParameter("productDescription"));
            p.setProductColor(request.getParameter("productColor"));
            p.setProductTitle(request.getParameter("productTitle"));
            p.setInventoryNumber(Integer.parseInt(request.getParameter("productInventoryNumber")));
            p.setProductSize(request.getParameter("productSize"));
            p.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
            p.setUpdateDate(Date.valueOf(LocalDate.now()));
            p.setProductImage("/Product/" + request.getParameter("productImage"));
            p.setQuantitySold(0);

            if (productDAO.insertProduct(p)) {

                c.commit();
                return true;
            }
        } catch (Exception e) {
            c.rollback();
        }
        c.rollback();
        c.close();
        return false;
    }
}
