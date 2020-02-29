/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;

/**
 *
 * @author HuyBin
 */
public class FileDAO {

    public String ReadContentFromFile(String pathFile) throws IOException {
        File file = new File(pathFile);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = "";
        String result = "";
        while ((st = br.readLine()) != null) {
            result+= st+"\n";
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException{
        FileDAO fileDAO = new FileDAO();
        String currentDirectory = System.getProperty("user.dir");
        String a = fileDAO.ReadContentFromFile(currentDirectory + "\\build\\web\\file\\email.html");
        System.out.println(a);
    }
}


