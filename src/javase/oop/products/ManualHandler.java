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
import javase.oop.customers.Company;
import javase.oop.customers.CustomerHandler;
import javase.oop.db.DBConnectionFactory;

/**
 *
 * @author Administrator
 */
public class ManualHandler {

    public static void insertManual(Manual manual) {
        // Retrieve db Connection
        Connection conn = DBConnectionFactory.getConnection();
        try {
            // prepare sql statement
            String sql = "INSERT INTO PRODUCTS"
                    + " ( PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)"
                    + " VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manual.getName());
            pstmt.setDouble(2, manual.getRetialPrice());
            pstmt.setString(3, manual.getDescription());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            sql = "INSERT INTO MANUAL"
                    + " ( MANUAL_PUBLISHER, PRODUCT_ID )"
                    + " VALUES (?,  PRODUCTS_SEQ.CURRVAL)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, manual.getPublishar());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            conn.commit();

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("This row is duplicated");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Manual> getAllManuals() {
        Connection conn = DBConnectionFactory.getConnection();
        ArrayList<Manual> manualList = new ArrayList<Manual>();
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " MANUAL_PUBLISHER"
                    + " FROM PRODUCTS, MANUAL"
                    + " WHERE PRODUCTS.PRODUCT_ID = MANUAL.PRODUCT_ID";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("PRODUCT_ID");
                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                String manualPublisher = rs.getString("MANUAL_PUBLISHER");

                Manual manual = new Manual(productId, productName, productRetailPrice,
                        productDesc, manualPublisher);

                manualList.add(manual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manualList;
    }

    public static Manual getManualById(int productId) {
        
        Connection conn = DBConnectionFactory.getConnection();
        Manual manual = null;
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " MANUAL_PUBLISHER"
                    + " FROM PRODUCTS, MANUAL"
                    + " WHERE PRODUCTS.PRODUCT_ID = MANUAL.PRODUCT_ID"
                    + " AND PRODUCTS.PRODUCT_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
               
                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                String manualPublisher = rs.getString("MANUAL_PUBLISHER");

                manual = new Manual(productId, productName, productRetailPrice,
                  productDesc, manualPublisher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manual;
    }

}
