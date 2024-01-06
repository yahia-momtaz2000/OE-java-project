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
public class Individual extends Customer {

    private String licNumber;

     // Constractor 
    public Individual(int id, String name, String Phone, String address, String licNumber) {
        super(id, name, Phone, address);
        this.licNumber = licNumber;
    }

    // Geter & Seter 
    public String getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber = licNumber;
    }

    @Override
    public String toString() {
        return "This Is Individual Object "+this.getName() ;
    }

}
