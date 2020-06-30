/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet
 */
public class DBConnect {

    public static Connection getConnection() {
        Connection cons = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cons = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyHocVien", "sa", "123");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cons;
    }

//    public static void main(String[] args) throws SQLException {
//        try (Connection c = DBConnect.getConnection()) {
//            System.out.println(c.toString());
//        }
//    }
}
