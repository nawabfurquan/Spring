package com.hibernatedemo;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int id = 2;
            Instructor tempInstructor = session.get(Instructor.class, id);
            System.out.println("Found instructor: " + tempInstructor);
            if (tempInstructor != null) {
                System.out.println("Deleting instructor.....");
                session.delete(tempInstructor);
            }
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            sessionFactory.close();
        }
    }
}
