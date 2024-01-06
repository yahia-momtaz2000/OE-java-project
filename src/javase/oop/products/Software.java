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
public class Software extends Product{
    
    private String license ;

    public Software( int id, String name, double retialPrice, String description , String license) {
        super(id, name, retialPrice, description);
        this.license = license;
    }

    public Software(String name, double retialPrice, String description, String license) {
        super(name, retialPrice, description);
        this.license = license;
    }

    
    
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    

    
    
}
