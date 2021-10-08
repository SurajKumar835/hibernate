package surajs_pkg;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
	public static void main(String[] args) {
		//create a Session Factory
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
		//create a session
		Session session=factory.getCurrentSession();
		try {			
			session.beginTransaction();
			//Query
			List<Student> myStudent=session.createQuery("from Student").list();
			//Display
			for(Student temp: myStudent)
			{
				System.out.println(temp);
			}
			//Query1 with lastName
			myStudent=session.createQuery("from Student s where s.lastName='Fran'").list();
			for(Student temp: myStudent)
			{
				System.out.println(temp);
			}
			//Query 2 
			myStudent=session.createQuery("from Student s where s.email LIKE '%831%'").list();
			for(Student temp: myStudent)
			{
				System.out.println(temp);
			}
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}
}
