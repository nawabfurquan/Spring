package com.hibernatedemo;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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
            Course course1 = new Course("Data Structures");
            Course course2 = new Course("Operating Systems");
            Course course3 = new Course("DBMS");
            // Adding courses to instructor to add a reference to them
            tempInstructor.add(course1);
            tempInstructor.add(course2);
            tempInstructor.add(course3);
            // Saving and persisting courses
            session.persist(course1);
            session.persist(course2);
            session.persist(course3);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
