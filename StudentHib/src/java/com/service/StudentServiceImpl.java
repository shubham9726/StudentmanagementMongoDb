package com.service;

import com.dao.StudentDao;
import com.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentdao;

    public StudentServiceImpl(StudentDao studentdao) {
        this.studentdao = studentdao;
    }

    public List<Student> getAllStudents() {

        List<Student> list = studentdao.getAllStudents();
        return list;
    }

    public void removeStudentdetails(int id) {
        studentdao.removeStudentdetails(id);
    }

    public void updateStudentdetails(Student student) {
        studentdao.updateStudentdetails(student);
    }

    public Student getEmpById(int id) {
        return studentdao.getEmpById(id);
    }

    public void addstudentdetails(Student student) {
        studentdao.addstudentdetails(student);
    }
}