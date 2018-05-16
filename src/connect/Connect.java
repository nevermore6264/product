package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/AwesomeBusiness";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123456";
    public static Connection getConnection()throws Exception{
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        return con;
    }
}
