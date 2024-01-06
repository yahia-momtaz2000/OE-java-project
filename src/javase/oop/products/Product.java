/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.products;

/**
 *
 * @author Administrator
 */
public abstract class Product {

    private int id;
    private String name;
    private double retialPrice;
    private String description;
    
    //Constractor
    public Product() {
    }
    
    public Product(int id, String name, double retialPrice, String description) {
        this.id = id;
        this.name = name;
        this.retialPrice = retialPrice;
        this.description = description;
    }

    public Product(String name, double retialPrice, String description) {
        this.name = name;
        this.retialPrice = retialPrice;
        this.description = description;
    }

    
    
    // Geter & Seter 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRetialPrice() {
        return retialPrice;
    }

    public void setRetialPrice(double retialPrice) {
        this.retialPrice = retialPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
