package com.decipherzone.studentweb.servlet;

import com.decipherzone.studentweb.dbopeartions.DbOperations;
import com.decipherzone.studentweb.entity.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet(name = "DisplayServlet", urlPatterns = "/DisplayServlet")

/**
 * DisplayServlet
 * @purpose - this class shows all the records of students
 */
public class DisplayServlet extends javax.servlet.http.HttpServlet {
    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @implnote - This method displays all the student records
     * If there is no record in the database the it redirects the error message to dispaly jsp page
     */
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        DbOperations dbOperations = new DbOperations();
        List<Student> arraylist = dbOperations.display();
        if (arraylist.isEmpty()) {
            request.setAttribute("quantity", 0);
            request.setAttribute("errormsg", "Student Record Is Empty");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/display.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("arraylist", arraylist);
            request.setAttribute("quantity", 1);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/display.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
