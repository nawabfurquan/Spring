package com.hibernatedemo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int id = 3;
            Student tempStudent = session.get(Student.class, id);
            System.out.println("Student: " + tempStudent);
            session.delete(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
