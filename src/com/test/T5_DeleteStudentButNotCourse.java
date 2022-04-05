package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Course;
import com.instructor.Student;

public class T5_DeleteStudentButNotCourse {

//	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Delete student, confirm course has not been deleted");
		
		Student st = session.get(Student.class, 5);

		//delete the course
		System.out.println("Deleting student: "+st);
		if(st != null) {
			session.delete(st);
			System.out.println("Successfully deleted the student");
		} else {
			System.out.println("Student does not exist in DB");
		}
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
