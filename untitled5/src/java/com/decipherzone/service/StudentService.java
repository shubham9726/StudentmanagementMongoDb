package com.decipherzone.service;


import com.decipherzone.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public void removeStudentdetails(int id);

    public void updateStudentdetails(Student student);

    public Student getEmpById(int id);

    public void addstudentdetails(Student student);
}