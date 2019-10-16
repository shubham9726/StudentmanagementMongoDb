package servlet;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DisplayServlet", urlPatterns = "/DisplayServlet")
public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        List<User> studentList = userDao.getAllUsers();
        request.setAttribute("student",studentList);
        request.setAttribute("erorr", 1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/template/listUser.jsp");
        requestDispatcher.forward(request, response);
    }
}
