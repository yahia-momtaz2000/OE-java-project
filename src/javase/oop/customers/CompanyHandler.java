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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oop.db.DBConnectionFactory;

/**
 *
 * @author Administrator
 */
public class CompanyHandler {

    public static void insertCompany(Company company) {

        // retrieve db Connection
        Connection conn = DBConnectionFactory.getConnection();

        try {
            // prepare sql statement
            String sql = "INSERT INTO CUSTOMERS"
                    + " (CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_CONTACT,"
                    + " CUSTOMER_DISCOUNT, CUSTOMER_TYPE_ID )"
                    + " VALUES ( ?, ?, ?, ?, ?, 2)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getName());
            pstmt.setString(2, company.getAddress());
            pstmt.setString(3, company.getPhone());
            pstmt.setString(4, company.getContact());
            pstmt.setInt(5, company.getDiscount());

            pstmt.executeUpdate();   /// for DMLs Insert - update - delete 
        } catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("This row is duplicated");
        }catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static ArrayList<Company> getAllCompanies() {
        Connection conn = DBConnectionFactory.getConnection();
        ArrayList<Company> customersList = new ArrayList<Company>();
        try {
            String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE,"
                    + " CUSTOMER_CONTACT, CUSTOMER_DISCOUNT"
                    + " FROM CUSTOMERS"
                    + " WHERE CUSTOMER_TYPE_ID = 2";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int companyId = rs.getInt("CUSTOMER_ID");
                String companyName = rs.getString("CUSTOMER_NAME");
                String companyAddress = rs.getString("CUSTOMER_ADDRESS");
                String companyPhone = rs.getString("CUSTOMER_PHONE");
                String companyContact = rs.getString("CUSTOMER_CONTACT");
                int companyDiscount = rs.getInt("CUSTOMER_DISCOUNT");
                
       Company company = new Company(companyId, companyName, companyPhone,
                        companyAddress, companyContact, companyDiscount);
                
                customersList.add(company);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return customersList;
    }

    public static Company getCompanyById(int companyId) {
          Connection conn = DBConnectionFactory.getConnection();
          Company company = null;
        try {
            String sql = "SELECT CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE,"
                            + " CUSTOMER_CONTACT, CUSTOMER_DISCOUNT"
                            + " FROM CUSTOMERS"
                            + " WHERE CUSTOMER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, companyId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String companyName = rs.getString("CUSTOMER_NAME");
                String companyAddress = rs.getString("CUSTOMER_ADDRESS");
                String companyPhone = rs.getString("CUSTOMER_PHONE");
                String companyContact = rs.getString("CUSTOMER_CONTACT");
                int companyDiscount = rs.getInt("CUSTOMER_DISCOUNT");
                
        company = new Company(companyId, companyName, companyPhone,
                        companyAddress, companyContact, companyDiscount);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return company;
    }
}