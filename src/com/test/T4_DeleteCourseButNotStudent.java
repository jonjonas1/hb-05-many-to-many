package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Course;

public class T4_DeleteCourseButNotStudent {

//	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Delete course, confirm student has not been deleted");
		
		Course cr = session.get(Course.class, 19);

		//delete the course
		System.out.println("Deleting course: "+cr);
		if(cr != null) {
			session.delete(cr);
			System.out.println("Successfully deleted the course");
		} else {
			System.out.println("Course does not exist in DB");
		}
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
