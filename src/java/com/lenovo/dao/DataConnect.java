package com.lenovo.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

class DataConnect {
    public static Connection getConnection() {
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con;
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lenovo", "root", "");
                    return con;
		} catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Database.getConnection() Error -->"
                                    + ex.getMessage());
                    return null;
		}
	}

    static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
