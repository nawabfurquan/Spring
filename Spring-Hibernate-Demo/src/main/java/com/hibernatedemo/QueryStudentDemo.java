package com.hibernatedemo;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student s where s.email LIKE '123%'", Student.class).getResultList();
            for (Student tempStudent : studentList) {
                System.out.println(tempStudent);
            }
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            sessionFactory.close();
        }
    }
}
