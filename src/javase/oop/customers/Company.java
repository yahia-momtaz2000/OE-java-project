/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.customers;

/**
 *
 * @author Administrator
 */
public class Company  extends Customer{
    
    private String contact;
    private int discount;

    // Constractor

    public Company( int id, String name, String Phone, String address , String contact, int discount) {
        super(id, name, Phone, address);
        this.contact = contact;
        this.discount = discount;
    }

    public Company(String name, String Phone, String address, String contact, int discount) {
        super(name, Phone, address);
        this.contact = contact;
        this.discount = discount;
    }

   
    
    // Geter & Seter 
    public String getContact() {
        return contact;
    }

    public int getDiscount() {
        return discount;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

  
    
    
    
    
    
    
}
