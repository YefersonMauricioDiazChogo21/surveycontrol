package com.questcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL ="";
    private static final String USSER ="";
    private static final String PASSWORD="";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(USSER, URL, PASSWORD);
    }
}
