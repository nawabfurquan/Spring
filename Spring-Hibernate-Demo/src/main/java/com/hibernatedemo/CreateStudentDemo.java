package com.hibernatedemo;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating Student object");
            Student student = new Student("Nawab", "Furquan", "123@gmail.com");
            session.beginTransaction();
            System.out.println("Saving student");
            session.persist(student);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            sessionFactory.close();
        }
    }
}
