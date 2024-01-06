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
public class Manual extends Product{
    
    private String Publishar ;

    public Manual(int id, String name, double retialPrice, String description, String Publishar) {
        super(id, name, retialPrice, description);
        this.Publishar = Publishar;
    }

    public Manual(String name, double retialPrice, String description, String Publishar) {
        super(name, retialPrice, description);
        this.Publishar = Publishar;
    }
    
    
    
    public String getPublishar() {
        return Publishar;
    }

    public void setPublishar(String Publishar) {
        this.Publishar = Publishar;
    }
    
    
    
    
}
