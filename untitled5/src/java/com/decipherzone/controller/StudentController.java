package com.decipherzone.controller;

import com.decipherzone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.decipherzone.service.StudentService;

import java.util.List;



@Controller
@EnableTransactionManagement
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/")
    public ModelAndView viewform(ModelAndView modelAndView) {
        List<Student> list = studentService.getAllStudents();
        if (list.isEmpty()) {
            modelAndView.addObject("message", "no record found !!");
            modelAndView.setViewName("viewform");
        } else {
            modelAndView.addObject("list", list);
            modelAndView.setViewName("viewform");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addstudent")
    @Transactional
    public ModelAndView addstudent() {
        return new ModelAndView("Student", "command", new Student());
    }

    @Transactional
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("student") Student student) {
        studentService.addstudentdetails(student);
        return new ModelAndView("redirect:/Student.jsp");
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addstudent(@PathVariable("student") Student student) {
        studentService.addstudentdetails(student);
        return new ModelAndView("redirect:/viewform");
    }

    @Transactional
    @RequestMapping(value = "/remove/{id}")
    public ModelAndView remove(@PathVariable int id) {
        studentService.removeStudentdetails(id);
        return new ModelAndView("redirect:/");
    }

    @Transactional
    @RequestMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable int id) {
        Student student = studentService.getEmpById(id);
        return new ModelAndView("UpdateStudentDetails", "command", student);
    }

    @Transactional
    @RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
    public ModelAndView updatestudent(@ModelAttribute("student") Student student) {
        studentService.updateStudentdetails(student);
        return new ModelAndView("redirect:/");
    }
}