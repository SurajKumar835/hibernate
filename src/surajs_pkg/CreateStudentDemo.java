package surajs_pkg;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		//create a Session Factory
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
				
		//create a session
		Session session=factory.getCurrentSession();
		try {
			String theDateOfBirthStr = "31/12/1998";
			 
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
 
            Student student= new Student("Pauly", "Doe", "paul@luv.com", theDateOfBirth);
			session.beginTransaction();
			session.save(student);			
			//Retrieve the object query also
			Student myStudent=session.get(Student.class,student.getId());			
			session.getTransaction().commit();
			System.out.println("Done" +myStudent);
		}finally {
			factory.close();
		}
	}

}
