package com.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() 
    {
        try
        {
            Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.instructor.Instructor.class);
			config.addAnnotatedClass(com.instructor.InstructorDetail.class);
			config.addAnnotatedClass(com.instructor.Course.class);
			config.addAnnotatedClass(com.instructor.Review.class);
			config.addAnnotatedClass(com.instructor.Student.class);
			
			
			StandardServiceRegistryBuilder builder = 
					new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			return factory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
