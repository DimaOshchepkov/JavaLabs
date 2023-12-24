package com.vyatsu.lab6.dao;

import lombok.AccessLevel;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    private static final String JDBC_URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    
    private static H2Connection h2Connection;
    
    public static H2Connection getH2Connection() {
        if (h2Connection == null)
            try {
                h2Connection = new H2Connection();
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return h2Connection;
        
    }
    @Getter(value = AccessLevel.PUBLIC)
    public Connection connection;

    private H2Connection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);
        connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

}
