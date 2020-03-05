/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.DBConnect;
import dao.ProducerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producer;

/**
 *
 * @author HuyBin
 */
public class ProducerServlet extends HttpServlet {
    ProducerDAO producerDAO = new ProducerDAO();
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
        int producerID = request.getParameter("producerID").compareTo("") != 0 ? Integer.parseInt(request.getParameter("producerID")) : 0;
        RequestDispatcher rd;

        switch (command) {
            case "insert":
                try {
                    String producerName = request.getParameter("producerName").compareTo("") != 0 || request.getParameter("producerName") == null ? request.getParameter("producerName") : "";
                    String producerAddress = request.getParameter("producerAddress").compareTo("") != 0 || request.getParameter("producerAddress") == null ? request.getParameter("producerAddress") : "";
                    String producerPhonenumber = request.getParameter("producerPhonenumber").compareTo("") != 0 || request.getParameter("producerPhonenumber") == null ? request.getParameter("producerPhonenumber") : "";

                    if (insertProducer(producerName, producerAddress, producerPhonenumber)) {
                        url = urlRoot + "/admin/producers.jsp";
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
                    String producerName = request.getParameter("producerName").compareTo("") != 0 || request.getParameter("producerName") == null ? request.getParameter("producerName") : "";
                    String producerAddress = request.getParameter("producerAddress").compareTo("") != 0 || request.getParameter("producerAddress") == null ? request.getParameter("producerAddress") : "";
                    String producerPhonenumber = request.getParameter("producerPhonenumber").compareTo("") != 0 || request.getParameter("producerPhonenumber") == null ? request.getParameter("producerPhonenumber") : "";

                    if (updateProducer(producerID, producerName, producerAddress, producerPhonenumber)) {
                        url = urlRoot + "/admin/producer-detail.jsp?producerID=" + producerID;
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
                    if (removeProducer(producerID)) {
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

    private boolean insertProducer(String producerName, String producerAddress, String producerPhonenumber) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            Producer p = new Producer();
            p.setProducerName(producerName);
            p.setProducerAddress(producerAddress);
            p.setProducerPhonenumber(producerPhonenumber);

            boolean isInsertProducer = producerDAO.insertProducer(p);
            if (isInsertProducer) {
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

    private boolean updateProducer(int producerID, String producerName, String producerAddress, String producerPhonenumber) throws SQLException, SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            Producer p = new Producer();
            p.setProducerID(producerID);
            p.setProducerName(producerName);
            p.setProducerAddress(producerAddress);
            p.setProducerPhonenumber(producerPhonenumber);

            boolean isUpdateProducer = producerDAO.updateProducer(p);
            if (isUpdateProducer) {
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

    private boolean removeProducer(int producerID) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            boolean isDeleteProducer = producerDAO.deleteProducer(producerID);
            if (isDeleteProducer) {
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

}
