/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.interfaces;

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
public class ParametersHandler {

    public static double getParamValueByName(String paramName) {
        Connection conn = DBConnectionFactory.getConnection();
            double paramValue = -1;
        try {

            String sql = "SELECT PARAM_VALUE"
                    + " FROM PARAMETERS"
                    + " WHERE PARAM_NAME = ? ";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, paramName);
                    
                  ResultSet rs =  pstmt.executeQuery();
                    while(rs.next()){
                        paramValue = rs.getDouble("PARAM_VALUE");
                    }
                    
        } catch (SQLException ex) {
            Logger.getLogger(ParametersHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paramValue;    
        
    }

}
