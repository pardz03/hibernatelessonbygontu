package com.kaizen.poc.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
	
		StudentInfo studentInfo1 = new StudentInfo();
		
		StudentInfo studentInfo2 = new StudentInfo();
		
		studentInfo1.setName("pardz1");
		studentInfo1.setBirthDate(new Date());
		
		studentInfo2.setName("pardz2");
		studentInfo2.setBirthDate(new Date());
		
		 SessionFactory sessionFactory = new Configuration()
		    .configure("/com/kaizen/poc/hibernate/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(studentInfo1);
		session.save(studentInfo2);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
