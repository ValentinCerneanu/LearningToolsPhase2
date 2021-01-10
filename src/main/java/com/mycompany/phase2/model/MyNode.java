/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.model;

import org.apache.jena.rdf.model.impl.ModelCom;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.graph.Node;

/**
 *
 * @author Valentin
 */
public class MyNode extends ResourceImpl {
    
    private boolean forEngineering;
    
    public MyNode(Node n, ModelCom mc){
        super(n, mc);
    }

    public boolean isForEngineering() {
        return forEngineering;
    }

    public void setforEngineering(boolean forEngineering) {
        this.forEngineering = forEngineering;
    }
}

