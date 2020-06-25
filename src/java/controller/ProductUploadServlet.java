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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author HuyBin
 */
public class ProductUploadServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String urlRoot = constants.AppConfig.getUrlRoot(request.getRequestURL().toString());
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String command = "";
        String tempString = "";
        String url = "";
        int temp = -1;
        int productID = -1;
        RequestDispatcher rd;
        Product p = new Product();

        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");

            try {
                // Parse the request
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (item.isFormField()) {
                        switch (item.getFieldName()) {
                            case "command":
                                command = item.getString() != "" ? item.getString() : "";
                                break;
                            case "productID":
                                productID = Integer.parseInt(item.getString()) != 0 ? Integer.parseInt(item.getString()) : 0;
                                if (command.compareTo("update") == 0 && productID != 0) {
                                    p = productDAO.getProduct(productID);
                                }
                                break;
                            case "categoryID":
                                temp = Integer.parseInt(item.getString("UTF-8") != "" ? item.getString("UTF-8") : "");
                                p.setCategoryID(temp);
                                break;
                            case "producerID":
                                temp = Integer.parseInt(item.getString() != "" ? item.getString("UTF-8") : "");
                                p.setProducerID(temp);
                                break;
                            case "productName":
                                tempString = item.getString("UTF-8") != "" ? item.getString("UTF-8") : "";
                                p.setProductName(tempString);
                                break;
                            case "productDescription":
                                tempString = item.getString("UTF-8") != "" ? item.getString("UTF-8") : "";
                                p.setProductDescription(tempString);
                                break;
                            case "productColor":
                                tempString = item.getString("UTF-8") != "" ? item.getString("UTF-8") : "";
                                p.setProductColor(tempString);
                                break;
                            case "productInventoryNumber":
                                temp = Integer.parseInt(item.getString("UTF-8") != "" ? item.getString("UTF-8") : "");
                                p.setInventoryNumber(temp);
                                break;
                            case "productSize":
                                tempString = item.getString("UTF-8") != "" ? item.getString("UTF-8") : "";
                                p.setProductSize(tempString);
                                break;
                            case "productPrice":
                                temp = Integer.parseInt(item.getString("UTF-8") != "" ? item.getString("UTF-8") : "");
                                p.setProductPrice(temp);
                                break;
                            case "productTitle":
                                tempString = item.getString("UTF-8") != "" ? item.getString("UTF-8") : "";
                                p.setProductTitle(tempString);
                                break;
                        }
                    } else {
                        String fileName = item.getName();
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "../../web/images/Product");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        if(command.compareTo("insert") == 0){
                            item.write(uploadedFile);
                            p.setProductImage("/Product/" + item.getName());
                        }else if(command.compareTo("update") == 0 && item.getName().compareTo("") != 0){
                            int start = p.getProductImage().lastIndexOf('/');
                            String imagesName = p.getProductImage().substring(start+1,p.getProductImage().length());
                            if (p.getProductImage().compareTo(item.getName()) != 0) {
                                item.write(uploadedFile);
                                p.setProductImage("/Product/" + item.getName());
                            }
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.compareTo("") == 0 || command == null) {
            url = "/admin/products-detail.jsp";
            rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        }

        switch (command) {
            case "insert":
                try {
//                    boolean isUploadFile = uploadFile(request, p);
//                    if (isUploadFile) {
                    if (insertProduct(p)) {
                        url = urlRoot + "/admin/products.jsp";
                        response.sendRedirect(url);
//                        rd = getServletContext().getRequestDispatcher(url);
//                        rd.forward(request, response);
                    } else {
                        url = request.getRequestURI();
                        rd = getServletContext().getRequestDispatcher(url);
                        rd.forward(request, response);
                    }
                } catch (SQLException ex) {
                    url = request.getRequestURI();
                    rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request, response);
                    Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "update": {
                try {
                    if (updateProduct(p)) {
                        url = urlRoot + "/admin/products-detail.jsp?productID="+p.getProductID();
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
                    Logger.getLogger(ProductUploadServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }

    private boolean insertProduct(Product p) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            p.setUpdateDate(Date.valueOf(LocalDate.now()));
            p.setQuantitySold(0);

            boolean isInsertProduct = productDAO.insertProduct(p);
            if (isInsertProduct) {
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

    private boolean updateProduct(Product p) throws SQLException {
        Connection c = DBConnect.getConnection();
        try {
            c.setAutoCommit(false);
            p.setUpdateDate(Date.valueOf(LocalDate.now()));
            p.setQuantitySold(0);

            boolean isUpdateProduct = productDAO.updateProduct(p);
            if (isUpdateProduct) {
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
