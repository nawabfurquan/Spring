package com.hibernatedemo;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int id = 3;
            InstructorDetail tempInstructor = session.get(InstructorDetail.class, id);
            System.out.println("Found instructor detail: " + tempInstructor);
            System.out.println("Found instructor: " + tempInstructor.getInstructor());
            // Unlinking the reference of instructor and instructor detail
            tempInstructor.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
