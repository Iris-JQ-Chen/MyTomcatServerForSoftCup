package dao;

import bean.UserBean;
import util.DBUtil;

import java.sql.*;

public class UserDao {
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    public static boolean Register(UserBean userBean){
        String user_name = userBean.getName();
        String user_pwd = userBean.getPwd();
        String user_email = userBean.getEmail();
//        String sql = "INSERT INTO t_user (user_name,user_pwd) VALUES ('" + user_name + "', '" + user_pwd + "' );";
//        connection = DBUtil.getConnection();
//
//        try {
//            statement = connection.createStatement();
//            int row = statement.executeUpdate(sql);
//            if (row != 1){
//                throw new RuntimeException("添加用户失败");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.releaseConnection(connection,statement,preparedStatement,resultSet);
//        }
        connection = DBUtil.getConnection();
        String sql = "INSERT INTO t_user (user_name,user_pwd,user_email) VALUES (?,?,?);";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user_name);
            preparedStatement.setString(2,user_pwd);
            preparedStatement.setString(3,user_email);
            int b = preparedStatement.executeUpdate();
            if (b > 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(connection,statement,preparedStatement,resultSet);
            return true;
        }

    }

    public static boolean Login(String user_name,String user_pwd){
        connection = DBUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE user_name = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user_name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String pwd = resultSet.getString("user_pwd");
                if (pwd.equals(user_pwd)){
                    return true;
                }
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseConnection(connection,statement,preparedStatement,resultSet);
        }

        return false;
    }

}
