package com.hibernatedemo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {
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
            int id = 1;
            Student tempStudent = session.get(Student.class, id);
            System.out.println("Student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());
            Course course1 = new Course("Operating System");
            Course course2 = new Course("DBMS");
            tempStudent.addCourse(course1);
            tempStudent.addCourse(course2);
            session.persist(course1);
            session.persist(course2);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
