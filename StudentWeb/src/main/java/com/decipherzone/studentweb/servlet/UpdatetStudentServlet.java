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
import java.util.List;

@WebServlet(name = "UpdatetStudentServlet", urlPatterns = "/UpdatetStudentServlet")
public class UpdatetStudentServlet extends HttpServlet {
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @implnote - This method fetch the details of a student using student id.
     * Student id is forwarded from the display jsp[ page.
     * Now the fetched data is send to updatestudentdetail servlet
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentid = Integer.parseInt(request.getParameter("studentid"));
        DbOperations dbOperations = new DbOperations();
        String studentname = "";
        int studentage = 0;
        if (dbOperations.idCheck(studentid)) {
            List<Student> arraylist = dbOperations.displayindividuals(studentid);
            for (Student student : arraylist) {
                studentname = student.getName();
                studentage = student.getAge();
            }
            request.setAttribute("studentid", studentid);
            request.setAttribute("studentname", studentname);
            request.setAttribute("studentage", studentage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/updatestudentdetail.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
