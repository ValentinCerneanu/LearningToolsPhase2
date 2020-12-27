/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phase2.model;

/**
 *
 * @author Valentin
 */
public class Tool {
    //private int id;
    private String name;
    private String description;
    private String url;
    private String type;
    private String category;
    private String webBased;
    private String price;
    private String subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String author;

    public Tool(String description, String url) {
        this.description = description;
        this.url = url;
    }
    
    public Tool(String name, String description, String url, String type, String category, boolean isWebBased, String price, String subjects, String author){
        this.name = name;
        this.description = description;
        this.url = url;
        this.type = type;
        this.category = category;
        this.webBased = webBased;
        this.price = price;
        this.subjects = subjects;
        this.author = author;
    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWebBased() {
        return webBased;
    }

    public void setWebBased(String webBased) {
        this.webBased = webBased;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
