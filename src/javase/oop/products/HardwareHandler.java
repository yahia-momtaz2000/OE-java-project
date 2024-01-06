/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oop.customers.CustomerHandler;
import javase.oop.db.DBConnectionFactory;

/**
 *
 * @author Administrator
 */
public class HardwareHandler {
   
    public static void insertHardware(Hardware hardware) {
        // Retrieve db Connection
        Connection conn = DBConnectionFactory.getConnection();
        try {
            // prepare sql statement
            String sql = "INSERT INTO PRODUCTS"
                    + " ( PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)"
                    + " VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hardware.getName());
            pstmt.setDouble(2, hardware.getRetialPrice());
            pstmt.setString(3, hardware.getDescription());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            sql = "INSERT INTO HARDWARE"
                    + " ( HARDWARE_WARRANTY_PRD, PRODUCT_ID )"
                    + " VALUES (?,  PRODUCTS_SEQ.CURRVAL)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hardware.getWarrantyPeriod());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            conn.commit();

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("This row is duplicated");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Hardware> getAllHardware() {
        Connection conn = DBConnectionFactory.getConnection();
        ArrayList<Hardware> hardwareList = new ArrayList<Hardware>();
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " HARDWARE_WARRANTY_PRD"
                    + " FROM PRODUCTS, HARDWARE"
                    + " WHERE PRODUCTS.PRODUCT_ID = HARDWARE.PRODUCT_ID";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("PRODUCT_ID");
                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                int hardwareWarrantyPeriod = rs.getInt("HARDWARE_WARRANTY_PRD");

                Hardware hardware = new Hardware(productId, productName, productRetailPrice,
                        productDesc, hardwareWarrantyPeriod);

                hardwareList.add(hardware);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hardwareList;
    }

    public static Hardware getHardwareById(int productId) {
        
        Connection conn = DBConnectionFactory.getConnection();
        Hardware hardware = null;
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " HARDWARE_WARRANTY_PRD"
                    + " FROM PRODUCTS, HARDWARE"
                    + " WHERE PRODUCTS.PRODUCT_ID = HARDWARE.PRODUCT_ID"
                    + " AND PRODUCTS.PRODUCT_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
               
                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                int hardwareWarrantyPeriod = rs.getInt("HARDWARE_WARRANTY_PRD");

                hardware = new Hardware(productId, productName, productRetailPrice,
                  productDesc, hardwareWarrantyPeriod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hardware;
    } 
}
