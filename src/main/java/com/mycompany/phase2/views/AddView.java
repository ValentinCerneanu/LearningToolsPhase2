/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.views;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
public class AddView extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {

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
                    + "                 <h2 id=\"header\">Add new tool form</h2>\n"
                    + "             </div>\n" 
                    + "             <div class=\"col\">\n" 
                    + "             </div>\n" 
                    + "        </div>"
                    
                    + "        <div class=\"p-5 bg-white rounded shadow mb-5\">	\n"    
                    + "            <div id=\"expertregister\" aria-labelledby=\"expert-tab\" class=\"tab-pane px-4 py-5\">\n"
                    + "                <div id=\"login\">\n"
                    + "                <div class=\"auth-container\">\n"
                    + "                    <div id=\"login-row\" class=\"row justify-content-center align-items-center\">\n"
                    + "                        <div id=\"login-column\" class=\"col-md-6 row justify-content-center align-items-center\">\n"
                    + "                            <div id=\"register-box\" class=\"col-md-12\">\n"
                    + "                                <form id=\"login-form\" class=\"form\" action=\"AddController\" method=\"post\">\n"
                    + "                                    <h3 class=\"text-center\">Add Tool</h3>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <div class=\"form-row\">\n"
                    + "                                                <div class=\"col\">\n"
                    + "                                                        <input placeholder=\"Name\" type=\"text\" name=\"name\" id=\"name\" class=\"form-control\"required>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col\">\n"
                    + "                                                        <input placeholder=\"Type\" type=\"text\" name=\"type\" id=\"type\" class=\"form-control\"required>\n"
                    + "                                                </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <input placeholder=\"Description\" type=\"text\" name=\"description\" id=\"description\" class=\"form-control\" required>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <div class=\"form-row\">\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                    <input placeholder=\"Author\" type=\"text\" name=\"author\" id=\"author\" class=\"form-control\"required>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                    <input placeholder=\"Category\" type=\"text\" name=\"category\" id=\"category\" class=\"form-control\"required>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <div class=\"form-row\">\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                <input placeholder=\"Url\" type=\"text\" name=\"url\" id=\"url\" class=\"form-control\"required>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <input placeholder=\"Subjects\" type=\"text\" name=\"subjects\" id=\"subjects\" class=\"form-control\" required>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <div class=\"form-row\">\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                    <label for=\"webbased\">Web-based:</label>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"col\">	\n"
                    + "                                                    <label for=\"price\">Price:</label>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                            <div class=\"form-row\">\n"
                    + "                                                <div class=\"col\">\n"
                    + "                                                    <select id=\"webbased\" name=\"webbased\">\n"
                    + "                                                            <option value=\"true\">True</option>\n"
                    + "                                                            <option value=\"false\">False</option>\n"
                    + "                                                    </select>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"col\">\n"
                    + "                                                    <select id=\"price\" name=\"price\">\n"
                    + "                                                            <option value=\"free\">Free</option>\n"
                    + "                                                            <option value=\"paid\">Paid</option>\n"
                    + "                                                    </select>\n"
                    + "                                                </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"form-group\">\n"
                    + "                                        <div class=\"row align-items-center justify-content-center\">\n"
                    + "                                            <input type=\"submit\" name=\"submit\" class=\"btn register-btn btn-md\" value=\"submit\">\n"
                    + "                                       </div>\n"
                    + "                                    </div>\n"
                    + "                                </form>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "    </body>\n"
                    + "</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
