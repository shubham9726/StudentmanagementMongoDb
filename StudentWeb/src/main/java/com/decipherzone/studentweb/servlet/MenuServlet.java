package com.decipherzone.studentweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MenuServlet",
        urlPatterns = "/MenuServlet")
public class MenuServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @implnote - This method is used to call the jsp page with its corresponding servlet
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("add_student") != null) {
            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/addstudent.jsp");
            d.forward(request, response);
        }
        if (request.getParameter("remove_student") != null) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher d = servletContext.getRequestDispatcher("/RemoveStudentServlet");
            d.forward(request, response);
        }
        if (request.getParameter("display") != null) {
            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/display.jsp");
            d.forward(request, response);
        }
        if (request.getParameter("update_student") != null) {
            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/updatestudent.jsp");
            d.forward(request, response);
        }
    }
}
