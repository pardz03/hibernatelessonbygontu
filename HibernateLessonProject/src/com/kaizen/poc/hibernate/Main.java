package com.kaizen.poc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
			
		Student student = new Student();
		student.setStudent_name("pogi si pardz");
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("0916-0000-111");
		studentDetail.setStudent(student);
		
		student.setStudentDetail(studentDetail);
	
//		student.setStudentDetail(studentDetail);
		//this is an important step
//		studentDetail.setStudent(student);
		
		 SessionFactory sessionFactory = new Configuration()
		    .configure("/com/kaizen/poc/hibernate/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
