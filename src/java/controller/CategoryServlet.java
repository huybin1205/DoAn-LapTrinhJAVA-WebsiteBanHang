/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.DBConnect;
import dao.CategoryDAO;
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
import model.Category;

/**
 *
 * @author HuyBin
 */
public class CategoryServlet extends HttpServlet {

    CategoryDAO categoryDAO = new CategoryDAO();

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
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("command").compareTo("") != 0 ? request.getParameter("command") : "";
        String url = "";
        String urlRoot = constants.AppConfig.getUrlRoot(request.getRequestURL().toString());
        int categoryID = request.getParameter("categoryID").compareTo("") != 0 ? Integer.parseInt(request.getParameter("categoryID")) : 0;
        RequestDispatcher rd;

        switch (command) {
            case "insert":
                try {
                    String categoryName = request.getParameter("categoryName").compareTo("") != 0 || request.getParameter("categoryName") == null ? request.getParameter("categoryName") : "";

                    if (insertCategory(categoryName)) {
                        url = urlRoot + "/admin/category.jsp";
                        response.sendRedirect(url);
                    } else {
                        url = request.getRequestURI();
                        rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                } catch (SQLException ex) {
                    url = request.getRequestURI();
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    ex.printStackTrace();
                    Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "update":
                try {
                    String categoryName = request.getParameter("categoryName").compareTo("") != 0 || request.getParameter("categoryName") == null ? request.getParameter("categoryName") : "";

                    if (updateCategory(categoryID,categoryName)) {
                        url = urlRoot + "/admin/category-detail.jsp?categoryID=" + categoryID;
                        response.sendRedirect(url);
                    } else {
                        url = request.getRequestURI();
                        rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                } catch (SQLException ex) {
                    url = request.getRequestURI();
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    ex.printStackTrace();
                    Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "remove": {
                try {
                    if (removeCategory(categoryID)) {
                        response.getWriter().write("success");
                    }
                } catch (SQLException ex) {
                    response.getWriter().write("error");
                    Logger.getLogger(CategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

        }

    }

    private boolean insertCategory(String categoryName) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            category.setCategoryName(categoryName);
            category.setCategoryImage("");

            boolean isInsertCategory = categoryDAO.insertCategory(category);
            if (isInsertCategory) {
                c.commit();
                c.close();
                return true;
            }
        } catch (Exception e) {
            c.rollback();
        }
        c.rollback();
        c.close();
        return false;
    }

    private boolean updateCategory(int categoryID, String categoryName) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            Category category = new Category();
            category.setCategoryId(categoryID);
            category.setCategoryName(categoryName);
            category.setCategoryImage("");

            boolean isUpdateCategory = categoryDAO.updateCategory(category);
            if (isUpdateCategory) {
                c.commit();
                c.close();
                return true;
            }
        } catch (Exception e) {
            c.rollback();
        }
        c.rollback();
        c.close();
        return false;
    }

    private boolean removeCategory(int categoryID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        connection.setAutoCommit(false);

        //Proccesing
        try {
            if (categoryDAO.deleteCategory(categoryID)) {
                return true;
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
