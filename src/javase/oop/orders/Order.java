/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.orders;

import java.util.ArrayList;
import java.util.Date;
import javase.oop.customers.Customer;
import javase.oop.products.Product;

/**
 *
 * @author Administrator
 */
public class Order {

    private int id;
    private Date orderDate = new Date();
    private double orderTotal;
    private Customer customer;
    private ArrayList<OrderItem> itemsList = new ArrayList<>();

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<OrderItem> getItemsList() {
        return itemsList;
    }

    public void deleteOrderItem(Product product){
          
            for(int i = 0; i < itemsList.size(); i++){
                 if(product.getId() == itemsList.get(i).getProduct().getId()){
                         int currentQty = itemsList.get(i).getQuantity();
                         if(currentQty > 1){
                            itemsList.get(i).setQuantity(currentQty - 1);
                         }else{
                               itemsList.remove(i);
                         }
                 }
                 
                 
            }
    }
    
    public void addOrderItem(Product product) {
         boolean productFound = false;
        for(OrderItem item : itemsList){
            if(product.getId() == item.getProduct().getId()){
               int currentQty = item.getQuantity();
                item.setQuantity(currentQty + 1);
                      productFound = true;
                break;
            }
        }
     if(productFound == false){   
        OrderItem item = new OrderItem(product);
        item.setQuantity(1);
        itemsList.add(item);
     }

    }

    
    
    public void showOrderDetails() {
        System.out.println("This order no .  -------------- " + id + " ----------------------");
        System.out.println("Customer NAme = " + customer.getName());
        System.out.println("Order Date = " + orderDate);
        System.out.println("----------------- Order Items ------------------");
        for (OrderItem item : itemsList) {
        System.out.print(" Order Item No : " + item.getLinNbr());
            System.out.print(", Product name : " + item.getProduct().getName());
            System.out.print(", Quantity : " + item.getQuantity());
            System.out.print(", Item Total : " + item.getItemTotal());
            System.out.println("\n-------------------");
        }
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("Order Total = "+this.getOrderTotal());
    }

    public double getOrderTotal() {
        double sum = 0;
        for(OrderItem item : itemsList){
        
                sum = sum + item.getItemTotal();
            
        }
        orderTotal = sum;
        return orderTotal;
    }

    
    
    
    
    
}
