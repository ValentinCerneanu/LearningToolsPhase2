/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.views;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import com.mycompany.phase2.util.XmlParser;

/**
 *
 * @author Valentin
 */
public class ListView extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            // Task no 5 Display on your web interface the list of tools from your local XML
            File xml = new File("xml/tools.xml");
            File xsl = new File("xml/checkType.xsl");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource style = new StreamSource(xsl);
            Transformer transformer = transformerFactory.newTransformer(style);
            
            Document newDocument = XmlParser.getInstance().getDocument();
            
            
            StreamSource source = new StreamSource (xml);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(new DOMSource(newDocument), result);
            
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
                    + "        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>\n"
                    + "        <title>List Tools</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    
                    + "    <div class=\"container-fluid\">"
                    
                    + "        <div class=\"row\">"
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "             <div class=\"col-10\">\n" 
                    + "                 <h1 id=\"header\">Learning And Teaching Tools</h1>\n"
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>"
                    
                    + "        <div class=\"row\">"
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "             <div class=\"col-10\">\n" 
                    + "                 <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n"
                    + "                     <div class=\"collapse navbar\" id=\"navbarNav\">"
                    + "                         <ul class=\"navbar-nav\">\n"
                    + "                             <li class=\"nav-item active\">"
                    + "                                 <a class=\"nav-link\" href=\"index.jsp\">Home</a>\n"
                    + "                             </li>"
                    + "                             <li class=\"nav-item active\">"
                    + "                                 <a class=\"nav-link\" href=\"ListView\">List of tools</a>\n"
                    + "                             </li>"
                    + "                             <li class=\"nav-item active\">"     
                    + "                                 <a class=\"nav-link\" href=\"AddView\">Add new tool</a>\n"
                    + "                             </li>"
                    + "                             <li class=\"nav-item active\">\n" 
                    + "                                 <a class=\"nav-link\" href=\"UploadRDF\">Upload RDF file</a>\n" 
                    + "                             </li>"
                    + "                         </ul>\n"
                    + "                 </nav>\n"
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>"
                    
                    + "        <div class=\"row\">"
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "             <div class=\"col-10\">\n" 
                    + "                 <h2 id=\"header\">List of tools</h2>\n"
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>");
                    
            out.println(writer.toString());
            out.println("</div> "
                    + "</body>\n"
                    + "</html>\n");
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
