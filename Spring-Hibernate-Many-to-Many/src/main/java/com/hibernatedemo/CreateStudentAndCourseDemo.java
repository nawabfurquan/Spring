package com.hibernatedemo;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAndCourseDemo {
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
            Course tempCourse = new Course("C++");
            session.persist(tempCourse);
            System.out.println("Saved course: " + tempCourse);
            Student student1 = new Student("John", "Doe", "john@gmail.com");
            Student student2 = new Student("Nawab", "Furquan", "furquan@gmail.com");
            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);
            session.persist(student1);
            session.persist(student2);
            System.out.println("Saved students: " + tempCourse.getStudents());
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
