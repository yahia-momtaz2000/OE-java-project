/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.orders;

import javase.oop.interfaces.Taxable;
import javase.oop.products.Hardware;
import javase.oop.products.Product;

/**
 *
 * @author Administrator
 */
public class OrderItem {
    
    private int linNbr ;
    private static int lineNbrStatic = 0;
    private Product product ;
    private int quantity ;

    public OrderItem(Product product) {
                lineNbrStatic++;
                linNbr = lineNbrStatic;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getLinNbr() {
        return linNbr;
    }

    public void setLinNbr(int linNbr) {
        this.linNbr = linNbr;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public double getUnitPrice(){
        return product.getRetialPrice();
    }
    
    public double getItemTotal(){
        return getUnitPrice() * quantity + getTax();
    }
    
    public double getTax(){
        if(product instanceof Taxable){
             return ((Hardware) product).getTax( getUnitPrice() * quantity   );
        }else{
            return 0;
        }
    }
    
}
