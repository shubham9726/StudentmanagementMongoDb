package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    /*@Autowired
    public StudentController(StudentService  studentService) {
        this.studentService = studentService;
    }*/

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

    public ModelAndView addstudent() {
        return new ModelAndView("Student", "command", new Student());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("student") Student student) {
        studentService.addstudentdetails(student);
        return new ModelAndView("redirect:/Student.jsp");
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addstudent(@PathVariable ("student") Student student){
        studentService.addstudentdetails(student);
        return new ModelAndView("redirect:/viewform");
    }

    @RequestMapping(value = "/remove/{id}")
    public ModelAndView remove(@PathVariable int id) {
        studentService.removeStudentdetails(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable int id) {
        Student student = studentService.getEmpById(id);
        return new ModelAndView("UpdateStudentDetails", "command", student);
    }

    @RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
    public ModelAndView updatestudent(@ModelAttribute("student") Student student) {
        studentService.updateStudentdetails(student);
        return new ModelAndView("redirect:/");
    }
}