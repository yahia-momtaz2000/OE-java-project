/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop;

import javase.oop.customers.Company;
import javase.oop.customers.Customer;
import javase.oop.customers.CustomerHandler;
import javase.oop.orders.Order;
import javase.oop.orders.OrderHandler;
import javase.oop.products.Hardware;
import javase.oop.products.HardwareHandler;
import javase.oop.products.Product;
import javase.oop.products.Software;
import javase.oop.products.SoftwareHandler;

/**
 *
 * @author Administrator
 */
public class TestOE{
    public static void main(String[] args){

          Software office97 =  SoftwareHandler.getSoftwareById(100);   //  new Software(1, "Win 98", 300.0, "OS", "12312-123112-123122-13212");
       // Software office2017 = new Softhware(2, "Office 2017", 400.0, "Ms Office", "121-112-22-111");
        Hardware xeroxPrinter = HardwareHandler.getHardwareById(101); // new Hardware(3, "Xerox Printer", 500.0, "Printer", 3);
        // Hardware cannonScanner = new Hardware(4, "Canon Scanner", 300.0, "Scanners", 5);
        
        Customer zahranCo =  CustomerHandler.getCustomerById(100); // new Company(1, "Zahran Co", "0123123111","Cairo", "Ahmed Mohamed", 12);
        
        Order order1 = new Order(1001);
        order1.setCustomer(zahranCo);
        order1.addOrderItem(office97);
        order1.addOrderItem(xeroxPrinter);
        order1.addOrderItem(xeroxPrinter);
        order1.addOrderItem(xeroxPrinter);
        order1.addOrderItem(xeroxPrinter);
        
        order1.deleteOrderItem(xeroxPrinter);
        order1.deleteOrderItem(xeroxPrinter);
        order1.deleteOrderItem(office97);
        //order1.addOrderItem(office97, 4);
        
       // order1.addOrderItem(cannonScanner);
        //   order1.addOrderItem(cannonScanner);
       
        order1.showOrderDetails();  // preview
        OrderHandler.confirmOrder(order1);
        
    }
}