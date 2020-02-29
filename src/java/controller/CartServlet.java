/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Product;

/**
 *
 * @author HuyBin
 */
public class CartServlet extends HttpServlet {

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
        doPost(request, response);
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
        String command = request.getParameter("command");
        int productID = Integer.parseInt(request.getParameter("productID"));
        String requestQuantity = request.getParameter("quantity");
        int quantity = 0;
        if(requestQuantity.compareTo("") != 0){
            quantity = Integer.parseInt(requestQuantity);
        }
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        try {
            Product product = productDAO.getProduct(productID);
            switch (command) {
                case "plus":
                    cart.plusItemToCart(product, quantity);
                    break;
                case "remove":
                    cart.removeItemCart(productID);
                    break;
                case "update":
                    cart.updateItemCart(product, quantity);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("error");
//            response.sendRedirect("/WebsiteBanHang-Java/index.jsp");
        }
        session.setAttribute("cart", cart);
        response.getWriter().write("success");
    }
}
