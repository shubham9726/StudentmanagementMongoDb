package com.decipherzone.studentweb.servlet;

import com.decipherzone.studentweb.dbopeartions.DbOperations;
import com.decipherzone.studentweb.entity.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddStudentServlet", urlPatterns = "/AddStudentServlet")

/**
 * AddSTudentServlet
 * @purpose - This class Adds the details of a student forwarded from add student jsp page into database
 */

public class AddStudentServlet extends HttpServlet {

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @implnote - This method add student details in database.
     * if the age input by the user is greater than 120 than it redirect the error msg in display page
     * and if the details are correct than they are saved in the database
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String studentname = request.getParameter("studentname");
        int age = Integer.parseInt(request.getParameter("studentage"));
        if (age < 1 || age > 120) {
            request.setAttribute("check", true);
            request.setAttribute("quantity", 1);
            request.setAttribute("errormsg", "Age " + age + " Is not valid!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DisplayServlet");
            requestDispatcher.forward(request, response);
        } else {
            DbOperations dbOperations = new DbOperations();
            int id = dbOperations.generateID();
            Student student = new Student(studentname, age, id);
            dbOperations.addStudent(student);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
