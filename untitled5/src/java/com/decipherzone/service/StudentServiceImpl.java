package com.decipherzone.service;

import com.decipherzone.dao.StudentDao;
import com.decipherzone.model.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
 private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    private StudentDao studentdao;

    public StudentServiceImpl(StudentDao studentdao) {
        this.studentdao = studentdao;
    }

    public List<Student> getAllStudents() {
LOGGER.info("Getting list Of All Students From Database");
        List<Student> list = studentdao.getAllStudents();
        return list;
    }

    @Transactional
    public void removeStudentdetails(int id) {
        LOGGER.info("Removing student Details from database for student id = {}.", id);
        studentdao.removeStudentdetails(id);
    }

    @Transactional
    public void updateStudentdetails(Student student) {
        studentdao.updateStudentdetails(student);
    }

    @Transactional
    public Student getEmpById(int id) {
        return studentdao.getEmpById(id);
    }


    public void addstudentdetails(Student student) {
        studentdao.addstudentdetails(student);
    }
}