package servlet;

import bean.UserBean;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("user_name");
        String pwd = request.getParameter("user_pwd");
        String email = request.getParameter("user_email");

        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPwd(pwd);
        userBean.setEmail(email);

        boolean result = UserDao.Register(userBean);

        PrintWriter printWriter = response.getWriter();
        printWriter.print(result);
        printWriter.flush();
        printWriter.close();
    }
}
