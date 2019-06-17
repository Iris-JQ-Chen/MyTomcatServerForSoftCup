package servlet;

import bean.CNCBriefBean;
import com.google.gson.Gson;
import dao.CNCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SearchBriefServlet", urlPatterns = "/SearchBrief")
public class SearchBriefServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String des = request.getParameter("cnc_des");
        ArrayList<CNCBriefBean> briefList = CNCDao.SearchBriefList(des);
        Gson gson = new Gson();
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(briefList));
        printWriter.flush();
        printWriter.close();
    }
}
