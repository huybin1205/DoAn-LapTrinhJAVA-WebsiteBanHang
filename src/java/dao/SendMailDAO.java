/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import constants.AppConfig;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import model.Bill;

/**
 *
 * @author HuyBin
 */
public class SendMailDAO {

    public void sendMail(String email, Bill bill, HttpServletRequest request) throws IOException {
        // 1) get the session object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", AppConfig.HOST_NAME);
        props.put("mail.smtp.port", AppConfig.TSL_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication p = new PasswordAuthentication(AppConfig.APP_EMAIL, AppConfig.APP_PASSWORD);
                return p;
            }
        });

        // 2) compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(AppConfig.APP_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // 3) create HTML content
            message.setSubject(constants.Constants.STORE_NAME);
            FileDAO fileDAO = new FileDAO();
//            String currentDirectory = System.getProperty("user.dir");
            String currentDirectory = request.getServletContext().getRealPath("/");
            String pathFile = currentDirectory + "file\\email.html";
            System.out.println(pathFile);
            String contentHtml = fileDAO.ReadContentFromFile(pathFile);
            
            contentHtml = setParamContent(contentHtml, bill, request);
            System.out.println(contentHtml);
            message.setContent(contentHtml, "text/html");

            // 4) send message
            Transport.send(message);

            System.out.println("Message sent successfully");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SendMailDAO sendMail = new SendMailDAO();
//        sendMail.sendMail("huyprosoccer@gmail.com", new Bill(1,"2","3","4",5,6,Date.valueOf(LocalDate.now()),7));
    }

    private String setParamContent(String contentHtml, Bill bill, HttpServletRequest request) {
        contentHtml = contentHtml.replace("{{id}}", bill.getBillID() + "");
        contentHtml = contentHtml.replace("{{address}}", bill.getBillAddress()+ "");
        contentHtml = contentHtml.replace("{{email}}", bill.getBillEmail()+ "");
        contentHtml = contentHtml.replace("{{phonenumber}}", bill.getBillPhonenumber()+ "");
        contentHtml = contentHtml.replace("{{total}}", bill.getBillTotal()+ "");
        contentHtml = contentHtml.replace("{{date}}", bill.getBillOrderDate().toString());
        
        String url = request.getRequestURL().toString();
        int end = url.lastIndexOf('/');
        url = url.substring(0, end);
        System.out.println(url);
        contentHtml = contentHtml.replace("{{url}}", "");
        return contentHtml;
    }
}
