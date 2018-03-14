package com.mulesoft.training;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class Database implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(Database.class);
    
    public void afterPropertiesSet() throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/yaf?user=root&password=whishworks_123";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(dbURL);
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            logger.info("&&&& - DB Init - &&&&");
            int i=0;
            while (rs.next()){
                logger.info("there is next " + rs.getString(3));
                if(rs.getString(3).equalsIgnoreCase("FLIGHTS")) i=1; //set a marker that this table already exists
            }
            logger.info("&&&& - DB Init - &&&&");
           /* Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO FLIGHTS(PRICE, DESTINATION, ORIGIN) VALUES (555, 'SFO','YYZ')");
            stmt.executeUpdate("INSERT INTO FLIGHTS(PRICE, DESTINATION, ORIGIN) VALUES (450, 'LAX','YYZ')");
            stmt.executeUpdate("INSERT INTO FLIGHTS(PRICE, DESTINATION, ORIGIN) VALUES (777, 'SEA','SQL')");
            stmt.executeUpdate("INSERT INTO FLIGHTS(PRICE, DESTINATION, ORIGIN) VALUES (999, 'SFO','SQL')");
            */
        } 
        catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
    }
}