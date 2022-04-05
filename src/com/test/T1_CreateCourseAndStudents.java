package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Course;
import com.instructor.Student;

public class T1_CreateCourseAndStudents {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Creating new Course and Students");

		//create some courses
//		Course tempCourse1 = new Course("AP Computer science");
		
		Course cr = new Course("AP Computer science");
		
		
		System.out.println("\nSaving the course: "+cr);
		session.save(cr);
		
		Student st1 = new Student("John","Doe");
		Student st2 = new Student("Bob","Ross");
		
		cr.addStudent(st1);
		cr.addStudent(st2);
		
		System.out.println("Saving the students");
		session.save(st1);
		session.save(st2);
		System.out.println("Saved students: "+cr.getStudent());
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
