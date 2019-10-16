package com.decipherzone.studentweb.servlet;

import com.decipherzone.studentweb.dbopeartions.DbOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateStudentDetailServlet", urlPatterns = "/UpdateStudentDetailServlet")
public class UpdateStudentDetailServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @implnote -  This method update the details of a selected student.
     * If the age input by the user is greater than 120 than it shows the error msg in display page.
     * If all the user inputs are correct, it will call the updatestudent method which saves the
     * details in the database.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbOperations dbOperations = new DbOperations();
        String studentname = request.getParameter("studentname");
        int studentage = Integer.parseInt(request.getParameter("studentage"));
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        if (studentage < 1 || studentage > 120) {
            request.setAttribute("check", false);
            request.setAttribute("errormsg", studentage + " Is not valid!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DisplayServlet");
            requestDispatcher.forward(request, response);
        } else {
            dbOperations.updateStudent(studentage, studentname, studentid);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
