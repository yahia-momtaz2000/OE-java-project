/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.customers;

import java.util.Comparator;

/**
 *
 * @author Administrator
 */
public class Customer implements Comparator<Customer>{

    private int id;
    private String name;
    private String Phone;
    private String address;
    
    // Constractor
    public Customer() {
    }

    public Customer(int id, String name, String Phone, String address) {
        this.id = id;
        this.name = name;
        this.Phone = Phone;
        this.address = address;
    }

    public Customer(String name, String Phone, String address) {
        this.name = name;
        this.Phone = Phone;
        this.address = address;
    }
    
    
    
    // Geter & Seter 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compare(Customer o1, Customer o2) {
            if(o1.getId() > o2.getId()){
                return 1;
            }else if(o1.getId() < o2.getId()){
                return -1;
            }else{
                return 0;
            }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
    

}
