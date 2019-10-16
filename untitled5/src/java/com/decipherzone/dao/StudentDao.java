package com.decipherzone.dao;


import com.decipherzone.model.Student;

import java.util.List;

public interface StudentDao {

   public List<Student> getAllStudents();

    public void removeStudentdetails(int id);

    public void updateStudentdetails(Student student);

   public  Student getEmpById(int id);

    public void addstudentdetails(Student student);
}