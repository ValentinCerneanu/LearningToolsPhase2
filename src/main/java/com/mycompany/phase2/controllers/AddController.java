/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.mycompany.phase2.util.XmlParser;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "AddController")
public class AddController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            XmlParser xmlParser = XmlParser.getInstance();
            Document doc = xmlParser.getDocument();
            NodeList tools = xmlParser.getTools();
            
            Element root = doc.getDocumentElement();
            Element toolElement = doc.createElement("tool");
            root.appendChild(toolElement);

            Element name = doc.createElement("name");
            name.insertBefore(doc.createTextNode(request.getParameter("name")), name.getLastChild());
            toolElement.insertBefore(name, toolElement.getLastChild());

            Element description = doc.createElement("description");
            description.insertBefore(doc.createTextNode(request.getParameter("description")), description.getLastChild());
            toolElement.insertBefore(description, toolElement.getLastChild());

            Element link = doc.createElement("url");
            link.insertBefore(doc.createTextNode(request.getParameter("url")), link.getLastChild());
            toolElement.insertBefore(link, toolElement.getLastChild());

            Element style = doc.createElement("type");
            style.insertBefore(doc.createTextNode(request.getParameter("type")), style.getLastChild());
            toolElement.insertBefore(style, toolElement.getLastChild());

            Element category = doc.createElement("category");
            category.insertBefore(doc.createTextNode(request.getParameter("category")), category.getLastChild());
            toolElement.insertBefore(category, toolElement.getLastChild());

            Element web_based = doc.createElement("webbased");
            web_based.insertBefore(doc.createTextNode(request.getParameter("webbased")), web_based.getLastChild());
            toolElement.insertBefore(web_based, toolElement.getLastChild());

            Element price = doc.createElement("price");
            price.insertBefore(doc.createTextNode(request.getParameter("price")), price.getLastChild());
            toolElement.insertBefore(price, toolElement.getLastChild());

            Element subjects = doc.createElement("subjects");
            for (String s : request.getParameter("subjects").split(",")){
                Element subject = doc.createElement("subject");
                subject.insertBefore(doc.createTextNode(s), subject.getLastChild());
                subjects.insertBefore(subject, subjects.getLastChild());
            }
            
            xmlParser.setXml(doc);
            //request.getSession().setAttribute("tools", tools);
            RequestDispatcher rd = request.getRequestDispatcher("ListView");
            rd.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
