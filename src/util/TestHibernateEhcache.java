package util;

import my.model.Department;
import org.hibernate.Session;

public class TestHibernateEhcache 
{	
	public static void main(String[] args) 
	{
		try
		{
			//Open the hibernate session
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//fetch the department entity from database first time
			Department department = (Department) session.load(Department.class, new Integer(1));
			System.out.println(department.getName());
			
			//fetch the department entity again; Fetched from first level cache
			department = (Department) session.load(Department.class, new Integer(1));
			System.out.println(department.getName());
			
			//Let's close the session
			session.getTransaction().commit();
			session.close();

			
			//Try to get department in new session
			Session anotherSession = HibernateUtil.getSessionFactory().openSession();
			anotherSession.beginTransaction();
			
			//Here entity is already in second level cache so no database query will be hit
			department = (Department) anotherSession.load(Department.class, new Integer(1));
			System.out.println(department.getName());
			
			anotherSession.getTransaction().commit();
			anotherSession.close();
		}
		finally
		{
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount()); //Prints 1
			System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount()); //Prints 1
			
			HibernateUtil.shutdown();
		}
	}
	

}
