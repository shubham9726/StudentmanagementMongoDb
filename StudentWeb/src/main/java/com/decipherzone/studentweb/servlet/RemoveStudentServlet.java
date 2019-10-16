package com.decipherzone.studentweb.servlet;

import com.decipherzone.studentweb.dbopeartions.DbOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "RemoveStudentServlet", urlPatterns = "/RemoveStudentServlet")
public class RemoveStudentServlet extends javax.servlet.http.HttpServlet {

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @implnote - this method removes the details of the student using student id whic is forwarded
     * from the dispaly jsp page
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        DbOperations dbOperations = new DbOperations();
        if (dbOperations.idCheck(studentid)) {
            dbOperations.removeStudent(studentid);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
