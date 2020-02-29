/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;
import validator.UserValidator;

/**
 *
 * @author HuyBin
 */
public class UsersServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    UserValidator userValidator = new UserValidator();

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
//        processRequest(request, response);
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
        String command = request.getParameter("command");
        String url = "";
        Users users = new Users();
        HttpSession session = request.getSession();
        switch (command) {
            case "register":
                users.setUserAccount(request.getParameter("username"));
                users.setUserPassword(request.getParameter(("password")));
                users.setUserAddress(request.getParameter("address"));
                users.setUserName(request.getParameter("name"));
                users.setUserDateOfBirth(Date.valueOf(request.getParameter("dateofbirth")));
                users.setUserEmail(request.getParameter("email"));
                users.setUserPhonenumber(request.getParameter("phonenumber"));
                String isCheckUserValidate = userValidator.checkUserValidate(users);
                if(isCheckUserValidate.compareTo(constants.Constants.SUCCESS)!=0){
                    session.setAttribute("error", isCheckUserValidate);
                    session.setMaxInactiveInterval(1);
                    url = "/register.jsp";
                    break;
                }
                session.removeAttribute("error");
                userDAO.insertUser(users);
                session.setAttribute("user", users);
                url = "/index.jsp";
                break;
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                users = userDAO.login(username, password);
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/index.jsp";
                } else {
                    session.setAttribute("error", constants.Constants.NOTIFICATION_ERROR_LOGIN);
                    session.setMaxInactiveInterval(1);
                    url = "/login.jsp";
                }
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

//        processRequest(request, response);
}
