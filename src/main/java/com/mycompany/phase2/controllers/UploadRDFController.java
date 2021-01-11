/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.controllers;

import com.mycompany.phase2.model.MyNode;
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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.impl.ModelCom;
import org.apache.jena.rdf.model.impl.ResourceImpl;

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
        
        
        Property engineeringProperty = ResourceFactory.createProperty("http://www.toptools4learning.com/domain/engineering");
        
        ResIterator iterEngineeringProperty = model.listSubjectsWithProperty(engineeringProperty);
        if (iterEngineeringProperty.hasNext()) {
            System.out.println("The database contains vcards for:");
            while (iterEngineeringProperty.hasNext()) {
                System.out.println("  " + iterEngineeringProperty.nextResource()
                                              .getProperty(engineeringProperty)
                                              .getString());
            }
        } else {
            System.out.println("No vcards were found in the database");
        }
        
        ArrayList<String> toolsForEngineering = new ArrayList<>();
        ArrayList<String> socialNetworks = new ArrayList<>();
        ArrayList<String> top10Tools = new ArrayList<>();
        
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
            
            if(stmt.toString().contains("engineering") && predicate.toString().contains("member"))
            {
                System.out.println("toolsForEngineering:");
                toolsForEngineering.add(stmt.toString());
                System.out.println(stmt);
            }
            
            if(stmt.toString().contains("placement"))
            {
                if(Integer.parseInt(object.toString()) <= 10)
                    top10Tools.add(stmt.toString());
                System.out.println("top10Tools:");
                System.out.println(stmt);
            }
            
            if(stmt.toString().contains("social_network") && predicate.toString().contains("member"))
            {
                System.out.println("social_networks:");
                socialNetworks.add(stmt.toString());
                System.out.println(stmt);
            }
        }
        request.setAttribute("toolsForEngineering", toolsForEngineering);
        request.setAttribute("socialNetworks", socialNetworks);
        request.setAttribute("top10Tools", top10Tools);
        RequestDispatcher rd = request.getRequestDispatcher("UploadRDF");
        rd.forward(request, response);
    }
    
    Transformer<MyNode,Paint> vertexPaint = new Transformer<MyNode,Paint>() {
        public Paint transform(MyNode node) {
            if(node.isForEngineering())
                return Color.GREEN;
            else
                return Color.RED;
        }
    };
    
    private void buildGraph(Model model){
        DirectedGraph<MyNode,String> g = new DirectedSparseGraph<>();
        boolean includeLiterals = true;
        
        StmtIterator iter = model.listStatements();
        int i=0;
        while(iter.hasNext()){
            Statement stm = iter.nextStatement();
            RDFNode sub = stm.getSubject();
            RDFNode obj = stm.getObject();
            
            Resource r = (Resource) sub;
            ResourceImpl ri = (ResourceImpl) r;
            ModelCom mc = (ModelCom) ri.getModel();
            MyNode subNode = new MyNode(ri.asNode(), mc);
            
            Property  predicate = stm.getPredicate();
            if(stm.toString().contains("engineering") && predicate.toString().contains("member"))
            {
                subNode.setforEngineering(true);
            }
            
            g.addVertex(subNode);
            if(includeLiterals || !obj.isLiteral()){
                ModelCom mcObj = (ModelCom) obj.getModel();
                MyNode objNode = new MyNode(obj.asNode(), mcObj);
                
                g.addVertex(objNode);
                g.addEdge(String.valueOf(i) + " " + predicate.toString(), subNode, objNode, EdgeType.DIRECTED);
            }
            i++;
        }
        
        Layout<MyNode, String> layout = new FRLayout(g);
        layout.setSize(new Dimension(1600, 900));
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<MyNode,String> vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(1920, 1080)); //Sets the viewing area size
        
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);

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
