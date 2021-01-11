/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
public class UploadRDF extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<String> toolsForEngineering = (ArrayList<String>) request.getAttribute("toolsForEngineering");
            ArrayList<String> socialNetworks = (ArrayList<String>) request.getAttribute("socialNetworks");
            ArrayList<String> top10Tools = (ArrayList<String>) request.getAttribute("top10Tools");
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
                    + "        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>\n"
                    + "        <title>Add Tool</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
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
                    + "                 <h2 id=\"header\">Upload RDF file</h2>\n"
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>"
                    
                    + "        <div class=\"row\">"
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "             <div class=\"col-10\">\n" 
                    + "                 <form action=\"UploadRDFController\" method=\"post\" enctype=\"multipart/form-data\">\n" 
                    + "                 <input type=\"file\" id=\"myFile\" name=\"file\">\n" 
                    + "                 <input type=\"submit\">\n" 
                    + "                 </form>\n" 
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>");
                    
            if(toolsForEngineering != null)
            {
                out.println(
                          "        <div class=\"row top-buffer\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">" 
                        + "                 <h6 id=\"\">Tools for studying engineering:</h6>\n"  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
                        
                for(String toolForEngineering:toolsForEngineering)
                    out.println(
                          "        <div class=\"row\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">\n" 
                        +              toolForEngineering  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
            }
            
            if(socialNetworks != null)
            {
                out.println(
                          "        <div class=\"row top-buffer\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">" 
                        + "                 <h6 id=\"\">Social Networks:</h6>\n"  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
                        
                for(String socialNetwork:socialNetworks)
                    out.println(
                          "        <div class=\"row\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">\n" 
                        +              socialNetwork  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
            }
            
            if(top10Tools != null)
            {
                out.println(
                          "        <div class=\"row top-buffer\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">" 
                        + "                 <h6 id=\"\">Tools present in Top 10:</h6>\n"  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
                        
                for(String top10Tool:top10Tools)
                    out.println(
                          "        <div class=\"row\">"
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "             <div class=\"col-10\">\n" 
                        +              top10Tool  
                        + "             </div>\n" 
                        + "             <div class=\"col\">\n" 
                        + "             </div>\n" 
                        + "        </div>");
            }
            
            out.println(
                      "    </div>\n"
                    + "    </body>\n"
                    + "</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
