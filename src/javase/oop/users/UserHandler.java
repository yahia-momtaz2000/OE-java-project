/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oop.db.DBConnectionFactory;

/**
 *
 * @author Administrator
 */
public class UserHandler {

    public static boolean checkLogin(String userName, String password) {

        Connection conn = DBConnectionFactory.getConnection();
        boolean userFound = false;
        try {
            String sql = "SELECT COUNT(*) USER_COUNT"
                    + " FROM USERS"
                    + " WHERE USER_NAME = ?"
                    + " AND USER_PASSWORD = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, userName);
                    pstmt.setString(2, password);
                    
                ResultSet rs = pstmt.executeQuery();
                    int userCount = 0;
                    while(rs.next()){
                           userCount =  rs.getInt("USER_COUNT");
                    }
                
                    if(userCount > 0){
                        userFound = true;
                    }
                
        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userFound;
    }
}
