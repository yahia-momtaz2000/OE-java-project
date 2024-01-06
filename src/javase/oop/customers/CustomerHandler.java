/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oop.db.DBConnectionFactory;

/**
 *
 * @author Administrator
 */
public class CustomerHandler {

    public static void insertCustomer(Customer customer) {

        // retrieve db Connection
        Connection conn = DBConnectionFactory.getConnection();

        try {
            // prepare sql statement
            String sql = "INSERT INTO CUSTOMERS"
                    + " (CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE,CUSTOMER_TYPE_ID )"
                    + " VALUES ( ?, ?, ?, 0)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getAddress());
            pstmt.setString(3, customer.getPhone());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Customer> getAllCustomers() {
        Connection conn = DBConnectionFactory.getConnection();
            ArrayList<Customer> customersList = new ArrayList<Customer>();
        try {
            String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE"
                    + " FROM CUSTOMERS"
                    + " WHERE CUSTOMER_TYPE_ID = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("CUSTOMER_ID");
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerAddress = rs.getString("CUSTOMER_ADDRESS");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
            
               Customer customer = new Customer(customerId, customerName, customerPhone, customerAddress);
                customersList.add(customer);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customersList;
    }

 public static Customer getCustomerById(int customerId){
            Connection conn = DBConnectionFactory.getConnection();
            Customer customer = null;
        try {
            String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_PHONE, CUSTOMER_ADDRESS"
                    + " FROM CUSTOMERS"
                    + " WHERE CUSTOMER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String customerName = rs.getString("CUSTOMER_NAME");
                String customerPhone = rs.getString("CUSTOMER_PHONE");
                String customerAddress = rs.getString("CUSTOMER_ADDRESS");
            
               customer = new Customer(customerId, customerName, customerPhone, customerAddress);         
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
     }
    
     
}
