/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBConnectionFactory {
     private final static String USER = "oe";
     private final static String PASS = "oe";
     private final static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
     
    private static Connection conn = null;
     
    public static Connection getConnection(){
         try {
             conn = DriverManager.getConnection(DB_URL, USER, PASS);
             conn.setAutoCommit(false);
         }catch (SQLException ex) {
             Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return conn;
    }
    
}
