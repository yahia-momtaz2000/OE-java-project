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
public class SoftwareHandler {

    public static void insertSoftware(Software software) {
        // Retrieve db Connection
        Connection conn = DBConnectionFactory.getConnection();
        try {
            // prepare sql statement
            String sql = "INSERT INTO PRODUCTS"
                    + " ( PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)"
                    + " VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, software.getName());
            pstmt.setDouble(2, software.getRetialPrice());
            pstmt.setString(3, software.getDescription());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            sql = "INSERT INTO SOFTWARE"
                    + " ( SOFTWARE_LICENCE, PRODUCT_ID )"
                    + " VALUES (?,  PRODUCTS_SEQ.CURRVAL)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, software.getLicense());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 

            conn.commit();

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("This row is duplicated");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Software> getAllSoftware() {
        Connection conn = DBConnectionFactory.getConnection();
        ArrayList<Software> softwareList = new ArrayList<Software>();
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " SOFTWARE_LICENCE"
                    + " FROM PRODUCTS, SOFTWARE"
                    + " WHERE PRODUCTS.PRODUCT_ID = SOFTWARE.PRODUCT_ID";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("PRODUCT_ID");
                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                String softwareLicence = rs.getString("SOFTWARE_LICENCE");

                Software software = new Software(productId, productName, productRetailPrice,
                        productDesc, softwareLicence);

                softwareList.add(software);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return softwareList;
    }

    public static Software getSoftwareById(int productId) {

        Connection conn = DBConnectionFactory.getConnection();
        Software software = null;
        try {
            String sql = "SELECT PRODUCTS.PRODUCT_ID, PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC,"
                    + " SOFTWARE_LICENCE"
                    + " FROM PRODUCTS, Software"
                    + " WHERE PRODUCTS.PRODUCT_ID = Software.PRODUCT_ID"
                    + " AND PRODUCTS.PRODUCT_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String productName = rs.getString("PRODUCT_NAME");
                double productRetailPrice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                String productDesc = rs.getString("PRODUCT_DESC");
                String softwareLicence = rs.getString("SOFTWARE_LICENCE");

                software = new Software(productId, productName, productRetailPrice,
                        productDesc, softwareLicence);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return software;
    }

    
    public static void updateSoftware(Software software) {
        Connection conn = DBConnectionFactory.getConnection();

        try {
            String sql = "UPDATE PRODUCTS"
                    + " SET PRODUCT_NAME = ?,"
                    + " PRODUCT_RETAIL_PRICE = ?,"
                    + " PRODUCT_DESC = ?"
                    + " WHERE PRODUCT_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, software.getName());
            pstmt.setDouble(2, software.getRetialPrice());
            pstmt.setString(3, software.getDescription());
            pstmt.setInt(4, software.getId());

            pstmt.executeUpdate();

            sql = "UPDATE SOFTWARE"
                    + " SET SOFTWARE_LICENCE = ?"
                    + " WHERE PRODUCT_ID = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, software.getLicense());
            pstmt.setInt(2, software.getId());

            pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(SoftwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteSoftwareById(int productId) {

        Connection conn = DBConnectionFactory.getConnection();

        try {
            String sql = "DELETE SOFTWARE"
                    + " WHERE PRODUCT_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();

            sql = "DELETE PRODUCTS"
                    + " WHERE PRODUCT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(SoftwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
