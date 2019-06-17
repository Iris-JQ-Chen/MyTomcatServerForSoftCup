package servlet;

import bean.CNCRetailBean;
import com.google.gson.Gson;
import dao.CNCDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchRetailServlet", urlPatterns = "/SearchRetail")
public class SearchRetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer id = new Integer(request.getParameter("cnc_id"));
        CNCRetailBean retailBean = CNCDao.SearchRetailBean(id);
        Gson gson = new Gson();
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(gson.toJson(retailBean));
        printWriter.flush();
        printWriter.close();
    }
}
