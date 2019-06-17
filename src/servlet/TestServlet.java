package servlet;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Connection connection = DBUtil.getConnection();
//        PreparedStatement preparedStatement = null;
//        String sql = "update t_cnc set cnc_like=?,cnc_view=? where cnc_id=?";
//        try {
//            for (int i = 18; i < 413;i++){
//                int view = new Random().nextInt(10000);
//                int like = new Random().nextInt(view);
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setInt(1,like);
//                preparedStatement.setInt(2,view);
//                preparedStatement.setInt(3,i);
//                preparedStatement.execute();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.releaseConnection(connection,null,preparedStatement,null);
//        }
    }
}
