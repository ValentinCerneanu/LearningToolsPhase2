/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import org.w3c.dom.NodeList;
import org.w3c.dom.*;
import com.mycompany.phase2.util.XmlParser;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "ListController")
public class ListController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            XmlParser xmlParser = XmlParser.getInstance();
            //Task no 3 Read in memory the list of tools from your local XML file
            NodeList tools = xmlParser.getTools();
            
            for (int i = 0; i < tools.getLength(); i++) {
                Node toolNode = tools.item(i);
                System.out.println("\nCurrent Element :" + toolNode.getNodeName());
                if (toolNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element toolElement = (Element) toolNode;
                    System.out.println("id: " + toolElement.getAttribute("id"));
                    
                    System.out.println("category: " + toolElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("type: " + toolElement.getElementsByTagName("type").item(0).getTextContent());
                }
            }
            request.getSession().setAttribute("tools", tools);
            RequestDispatcher rd = request.getRequestDispatcher("ListView");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
