package servlet;

import java.io.IOException;


import dao.UserDao;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserController", urlPatterns = "/UserController")
public class UserController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/WEB-INF/template/student.jsp";

    private static String LIST_USER = "/WEB-INF/template/studentList.jsp";

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
            request.setAttribute("student12", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String rollNo = request.getParameter("rollNo");
            Student student = dao.getUserById(Integer.valueOf(rollNo));
            request.setAttribute("student", student);
        } else if (action.equalsIgnoreCase("/WEB-INF/template/studentList")) {
            forward = LIST_USER;
            request.setAttribute("students", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
        student.setAddress(request.getParameter("address"));
        student.setMobile(request.getParameter("mobile"));
        dao.checkUser(student);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("student12", dao.getAllUsers());
        view.forward(request, response);
    }
}