package com.kaizen.poc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
			
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setAddress_detail("Konoha Village");
		
		Student student1 = new Student();
		student1.setStudent_name("Naruto");
		student1.setStudentAddress(studentAddress);
		
		Student student2 = new Student();
		student2.setStudent_name("Saske");
		student2.setStudentAddress(studentAddress);
		
		Student student3 = new Student();
		student3.setStudent_name("Sakura");
		student3.setStudentAddress(studentAddress);
		
		studentAddress.getStudents().add(student1);
		studentAddress.getStudents().add(student2);
		studentAddress.getStudents().add(student3);
		
		 SessionFactory sessionFactory = new Configuration()
		    .configure("/com/kaizen/poc/hibernate/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(studentAddress);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
}
