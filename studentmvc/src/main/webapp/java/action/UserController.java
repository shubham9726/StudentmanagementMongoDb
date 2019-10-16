package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet(name = "UserController", urlPatterns = "/UserController")
public class UserController extends HttpServlet {


    private static String INSERT_OR_EDIT = "/WEB-INF/template/user.jsp";

    private static String LIST_USER = "/WEB-INF/template/listUser.jsp";

    private UserDao dao;
    private int rollNo;
    private String name;

    public UserController() throws Exception {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            String rollNo = request.getParameter("rollNo");
            dao.deleteUser(Integer.valueOf(rollNo));
            forward = LIST_USER;
            request.setAttribute("student", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String rollNo = request.getParameter("rollNo");
            User user = dao.getUserById(Integer.valueOf(rollNo));
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("/WEB-INF/template/listUser")) {
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
        user.setAddress(request.getParameter("address"));
        user.setMobile(request.getParameter("mobile"));
      /* user.setName(name);*/
        dao.checkUser(user);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("student", dao.getAllUsers());
        view.forward(request, response);
    }
}