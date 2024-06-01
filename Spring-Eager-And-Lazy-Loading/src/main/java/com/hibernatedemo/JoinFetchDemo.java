package com.hibernatedemo;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinFetchDemo {
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
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                + "JOIN FETCH i.courses "
                                + "where i.id=:instructorId", Instructor.class);
            query.setParameter("instructorId", id);
            Instructor tempInstructor = query.getSingleResult();
            session.getTransaction().commit();
            session.close();
            System.out.println("luv2code: Found instructor: " + tempInstructor);
            System.out.println("luv2code: Associated courses: " + tempInstructor.getCourses());
            System.out.println("luv2code: Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
