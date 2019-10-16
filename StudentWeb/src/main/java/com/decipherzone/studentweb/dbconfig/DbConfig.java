package com.decipherzone.studentweb.dbconfig;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @purpose -  purpose of this class is to create connection with database and the return it when this class
 * is called from other classes.
 */
public class DbConfig {
    private static Logger log = Logger.getLogger(DbConfig.class);

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false", "root", "root");
        } catch (Exception s) {
            log.error(s);
        }

        return null;
    }
}
