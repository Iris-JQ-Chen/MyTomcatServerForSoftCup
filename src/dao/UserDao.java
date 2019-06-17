package dao;

import bean.UserBean;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

    public static void addUser(UserBean userBean){
        Connection connection = null;
        Statement statement = null;

        String user_name = userBean.getName();
        String user_pwd = userBean.getPwd();

        String sql = "INSERT INTO t_user (user_name,user_pwd) VALUES ('" + user_name + "', '" + user_pwd + "' );";

        connection = DBUtil.getConnection();

        try {
            statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            if (row != 1){
                throw new RuntimeException("添加用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseConnection(connection,statement,null);
        }
    }

}
