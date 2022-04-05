package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Course;
import com.instructor.Student;

public class T3_AddStudentToMoreCourses {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Adding Student to more courses");
		
		Course cr1 = session.get(Course.class, 15);
		System.out.println("Course info: " + cr1.getTitle());
		
		Student st1 = session.get(Student.class, 5);
		System.out.println("Adding student to course:");
//		cr1.addStudent(st1); // adds course only once, second run output exceptions
		if(cr1.getStudent().isEmpty()) {
			cr1.addStudent(st1);
		}

		System.out.println(cr1.getStudent());
		System.out.println(st1.getCourse());
		
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
