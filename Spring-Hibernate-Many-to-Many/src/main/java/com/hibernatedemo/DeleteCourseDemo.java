package com.hibernatedemo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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
            int id = 11;
            Course tempCourse = session.get(Course.class, id);
            System.out.println("Course: " + tempCourse);
            session.delete(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
