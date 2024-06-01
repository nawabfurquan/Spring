package com.hibernatedemo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
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
            Course tempCourse = new Course("Data Structures");
            tempCourse.add(new Review("Good Course"));
            tempCourse.add(new Review("Great Course"));
            tempCourse.add(new Review("Good Course but needs more practice work"));
            System.out.println("Saving course: " + tempCourse);
            System.out.println("Reviews: " + tempCourse.getReviews());
            session.persist(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
