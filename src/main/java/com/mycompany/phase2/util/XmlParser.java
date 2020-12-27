/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.util;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class XmlParser {
    
    private static XmlParser instance = null;
    private Document document;
    
    public static XmlParser getInstance(){
        if(instance == null)
            return new XmlParser();
        else
            return instance;
    }
    
    private XmlParser(){
        try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("xml/tools.xml");

        document = builder.parse(inputFile);
        document.getDocumentElement().normalize();
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Document getDocument(){
        return this.document;
    }
    
    public void setXml(Document doc){
        this.document=doc;
    }
    
    public NodeList getTools(){
        try {
            NodeList tools = this.document.getElementsByTagName("tool");
            return tools;
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Document createXmlFromNodeList(NodeList nodeList){
        try {
            Document newXmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = newXmlDocument.createElement("tools");
            newXmlDocument.appendChild(root);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Node copyNode = newXmlDocument.importNode(node, true);
                root.appendChild(copyNode);
            }
            return newXmlDocument;
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
