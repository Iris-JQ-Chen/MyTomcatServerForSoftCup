package util;

import java.sql.*;

public class DBUtil {

    private static final String MysqlDriver = "com.mysql.jdbc.Driver";
    private static final String connectUrl = "jdbc:mysql://localhost:3306/mysql_for_soft_cup";
    private static final String user = "root";
    private static final String password = "root";
    static {
        try {
            Class.forName(MysqlDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectUrl,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void releaseConnection(Connection connection, Statement statement, ResultSet resultSet){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
