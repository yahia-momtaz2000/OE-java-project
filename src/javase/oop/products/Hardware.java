/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.products;

import javase.oop.interfaces.Taxable;

/**
 *
 * @author Administrator
 */
public class Hardware extends Product implements Taxable{
    private int warrantyPeriod ;

    public Hardware( int id, String name, double retialPrice, String description ,int warrantyPeriod) {
        super(id, name, retialPrice, description);
        this.warrantyPeriod = warrantyPeriod;
    }

    public Hardware( String name, double retialPrice, String description, int warrantyPeriod) {
        super(name, retialPrice, description);
        this.warrantyPeriod = warrantyPeriod;
    }

    public Hardware(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    
    
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double getTax(double value) {
        return value * Taxable.TAX_PCT / 100.0 ;
        
    }
    
    
    
    
}
