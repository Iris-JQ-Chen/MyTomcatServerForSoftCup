package dao;

import bean.CNCBriefBean;
import bean.CNCRetailBean;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class CNCDao {

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    public static ArrayList<CNCBriefBean> SearchBriefList(String des){
        ArrayList<CNCBriefBean> briefList = new ArrayList<>();
        connection = DBUtil.getConnection();
        String sql = "SELECT * FROM t_cnc WHERE cnc_des LIKE ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%"+des+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CNCBriefBean briefBean = new CNCBriefBean();
                briefBean.setCncId(resultSet.getInt("cnc_id"));
                briefBean.setCncDes(resultSet.getString("cnc_des"));
                briefBean.setCncDiagnose(resultSet.getString("cnc_diagnose"));
                briefBean.setCncSource(resultSet.getString("cnc_source"));
                briefBean.setCncLike(resultSet.getInt("cnc_like"));
                briefBean.setCncView(resultSet.getInt("cnc_view"));
                briefList.add(briefBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseConnection(connection,statement,preparedStatement,resultSet);
        }
        return briefList;
    }

    public static CNCRetailBean SearchRetailBean(int id){
        CNCRetailBean retailBean = null;
        connection = DBUtil.getConnection();
        String sql = "SELECT * FROM t_cnc WHERE cnc_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            int cnc_id = resultSet.getInt("user_id");
            String cnc_des = resultSet.getString("cnc_des");
            String cnc_diagnose = resultSet.getString("cnc_diagnose");
            String cnc_removal = resultSet.getString("cnc_removal");
            String cnc_brand = resultSet.getString("cnc_brand");
            String cnc_model = resultSet.getString("cnc_model");
            String cnc_code = resultSet.getString("cnc_code");
            String cnc_location = resultSet.getString("cnc_location");
            String cnc_threshold = resultSet.getString("cnc_threshold");
            String cnc_reality = resultSet.getString("cnc_reality");
            String cnc_source = resultSet.getString("cnc_source");
            int cnc_like = resultSet.getInt("cnc_like");
            int cnc_view = resultSet.getInt("cnc_view");

            retailBean = new CNCRetailBean(cnc_id,cnc_des,cnc_diagnose,cnc_removal,cnc_brand,cnc_model,cnc_code,cnc_location,cnc_threshold,cnc_reality,cnc_source,cnc_like,cnc_view);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.releaseConnection(connection,statement,preparedStatement,resultSet);
        }
        
        return retailBean;
    }

}
