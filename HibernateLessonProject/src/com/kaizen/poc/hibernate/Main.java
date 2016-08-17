package com.kaizen.poc.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
			
		Student student = new Student();
		Student student1 = new Student();
		student1.setStudent_name("pardz pogi");
		
		Student student2 = new Student();
		student2.setStudent_name("naruto");
		
		Student student3 = new Student();
		student3.setStudent_name("saske");
		
		Student student4 = new Student();
		student4.setStudent_name("sakura");
		
		 SessionFactory sessionFactory = new Configuration()
		    .configure("/com/kaizen/poc/hibernate/hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		
		student = session.get(Student.class, 1);
		
		System.out.println("FECTH STUDENT NAME : " + student.getStudent_name());
		System.out.println("FECTH STUDENT ID : " + student.getStudent_id());
		student.setStudent_name("pardz ang pinakapogi");
		session.update(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
}
