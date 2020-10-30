/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author REHOBOTH
 */
public class Dbh {
    private final String URL = "jdbc:derby://localhost:1527/ALMSSystem";
    private final String USERNAME = "Akashi";
    private final String PASSWORD = "Akashi";
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
