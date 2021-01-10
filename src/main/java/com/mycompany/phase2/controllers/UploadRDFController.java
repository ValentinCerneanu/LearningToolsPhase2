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
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;


import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.*;

import org.apache.commons.collections15.Transformer;
import java.awt.Paint;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Valentin
 */
@MultipartConfig
@WebServlet(name = "UploadRDFController")
public class UploadRDFController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); 
        InputStream fileContent = filePart.getInputStream();
      
        Model model = ModelFactory.createDefaultModel();
        
        if (fileContent == null) {
            throw new IllegalArgumentException("File: not found");
        }

        model.read(fileContent, null);
        //model.write(System.out);
        
        buildGraph(model);
        
        StmtIterator iter = model.listStatements();
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();  // get next statement
            Resource  subject   = stmt.getSubject();     // get the subject
            Property  predicate = stmt.getPredicate();   // get the predicate
            RDFNode   object    = stmt.getObject();      // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
               System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }

            System.out.println(" .");
        }
        
        processRequest(request, response);
    }
    
    Transformer<RDFNode,Paint> vertexPaintGreen = new Transformer<RDFNode,Paint>() {
        public Paint transform(RDFNode i) {
            return Color.GREEN;
        }
    };
    
    Transformer<RDFNode,Paint> vertexPaintRed = new Transformer<RDFNode,Paint>() {
        public Paint transform(RDFNode i) {
            return Color.RED;
        }
    };
    
    private void buildGraph(Model model){
        DirectedGraph<RDFNode,String> g = new DirectedSparseGraph<>();
        boolean includeLiterals = true;
        
        StmtIterator iter = model.listStatements();
        int i=0;
        while(iter.hasNext()){
            Statement stm = iter.nextStatement();
            RDFNode sub = stm.getSubject();
            RDFNode obj = stm.getObject();
            g.addVertex(sub);
            if(includeLiterals || !obj.isLiteral()){
                g.addVertex(obj);
                
                Property  predicate = stm.getPredicate();
                g.addEdge(String.valueOf(i) + " " + predicate.toString(), sub, obj, EdgeType.DIRECTED);
            }
            i++;
        }
        
        Layout<RDFNode, String> layout = new FRLayout(g);
        layout.setSize(new Dimension(1900, 1000));
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<RDFNode,String> vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(1920, 1080)); //Sets the viewing area size
        
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaintGreen);

        JFrame frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true); 
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
