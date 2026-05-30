/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Sahil
 */
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnectionPool {

    private static final BasicDataSource bd;

    static {
        bd = new BasicDataSource();

        bd.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bd.setUrl("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
        bd.setUsername("root");
        bd.setPassword("sahil");

        bd.setInitialSize(5);
        bd.setMaxTotal(20);
        bd.setMinIdle(5);
        bd.setMaxIdle(10);

    }

    public static Connection getConnection() throws Exception {
        return bd.getConnection();
    }
}
