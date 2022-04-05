package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Course;
import com.instructor.Student;

public class T2_AssigningStudentToCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Creating new Course and Students");

		//create some courses
//		Course cr2 = new Course("Math");
//		System.out.println("\nSaving the course: "+cr2);
//		session.save(cr2);
		
		
		Course cr2 = session.get(Course.class, 16);
		System.out.println("Course info: " + cr2.getTitle());
		
				
		// getting student into var and assigning to course
		Student st1=session.get(Student.class, 5);
		cr2.addStudent(st1);
		System.out.println("Student: "+st1+"assigned course: "+cr2);
		
//		Student st1 = new Student("Bob","Kafa");
//		session.save(st1);
		
//		//Delete Student
//		Student st1 = session.get(Student.class, 4);
//		if (st1 != null) {
//			System.out.println("Deleting student only: " + st1);
//			session.delete(st1);
//		}
		System.out.println("Student Info: "+cr2.getStudent().size());
		System.out.println("Student Info: "+cr2.getStudent());
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
