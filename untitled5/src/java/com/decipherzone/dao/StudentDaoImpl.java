package com.decipherzone.dao;

import com.decipherzone.model.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final static Logger logger = Logger.getLogger(String.valueOf(StudentDaoImpl.class));

    private SessionFactory sessionFactory;

    @Autowired
    public StudentDaoImpl(SessionFactory sessionFactory) throws Exception {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = this.sessionFactory.openSession();
        List<Student> list = session.createQuery("from Student").list();
        for (Object student : list) {
            logger.info("Student List::" + student);
        }
        return list;
    }

    public void removeStudentdetails(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query query = session.createQuery("delete from Student where id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.getMessage();
            transaction.rollback();
        }
        session.close();
    }

    @Override
    public void updateStudentdetails(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.getMessage();
        }
        session.close();
    }

    @Override
    public Student getEmpById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Student student = null;
        try {
            transaction.begin();
            student = (Student) session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.getMessage();
            transaction.rollback();
        }
        session.close();
        return student;
    }

    @Override
    public void addstudentdetails(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            e.getMessage();
            transaction.rollback();
        }
        session.close();
    }
}
