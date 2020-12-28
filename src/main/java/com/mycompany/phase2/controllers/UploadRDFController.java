/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author Valentin
 */
@MultipartConfig
@WebServlet(name = "UploadRDFController")
public class UploadRDFController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
      
        Model model = ModelFactory.createDefaultModel();
        
        if (fileContent == null) {
            throw new IllegalArgumentException("File: not found");
        }

        model.read(fileContent, null);
        model.write(System.out);
        
        processRequest(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
        } catch (Exception ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
