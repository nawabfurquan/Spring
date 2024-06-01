package com.hibernatedemo;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating instructor object");
            InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code", "Coding");
            Instructor tempInstructor = new
                        Instructor("Chad", "Darby", "luv2code@gmail.com");
            // Setting instructor detail to link instructor and instructor detail
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor");
            session.persist(tempInstructor);
            System.out.println("Committing instructor");
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            sessionFactory.close();
        }
    }
}
