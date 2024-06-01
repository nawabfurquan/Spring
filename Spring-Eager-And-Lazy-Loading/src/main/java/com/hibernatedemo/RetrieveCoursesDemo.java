package com.hibernatedemo;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveCoursesDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + tempInstructor);
            System.out.println("Associated courses: " + tempInstructor.getCourses());
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
