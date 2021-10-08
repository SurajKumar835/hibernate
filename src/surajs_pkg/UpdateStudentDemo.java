package surajs_pkg;
	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	public class UpdateStudentDemo {
		public static void main(String[] args) {
			//create a Session Factory
			SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
			//create a session
			Session session=factory.getCurrentSession();
			try {			
				session.beginTransaction();
				//Query
				session.createQuery("update Student set lastName='Sunrise' where email LIKE '%831%'").executeUpdate();
				//Delete Query
				session.createQuery("delete from Student where email LIKE '%831%'").executeUpdate();
				session.getTransaction().commit();
				System.out.println("Done");
			}finally {
				factory.close();
			}
		}
	}
