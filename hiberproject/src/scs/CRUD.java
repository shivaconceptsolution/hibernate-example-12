package scs;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUD {
	static SessionFactory sf;
	static Scanner sc = new Scanner(System.in);
	static int jobid;
	static String jobtitle;
	static Session s;
	static void connection()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    sf = cfg.buildSessionFactory();
	    s = sf.openSession();
	}
	static void insertOperation()
	{
		
	    
	    Transaction tx = s.beginTransaction();
	    System.out.println("Enter job id");
	    jobid = sc.nextInt();
	    Object o = s.get(Job.class, new Integer(jobid));
	    if(o==null)
	    {
	    System.out.println("Enter job title");
	    jobtitle = sc.next();
	    Job obj = new Job();
	    obj.setJobid(jobid);
	    obj.setJobtitle(jobtitle);
	    s.save(obj);
	    tx.commit();
	    }
	    else
	    {
	    	System.out.println("This job is already present into db");
	    }
	}
	static void selectOperation()
	{
		   Query q = s.createQuery("from Job j"); //select * from job
		   List lst = q.list();
		   Iterator it = lst.iterator();
		   while(it.hasNext())
		    {
		    	Job obj =(Job) it.next();
		    	System.out.println(obj.getJobid() + " "+obj.getJobtitle());
		    }
		  
	}
	static void updateOperation()
	{
		Scanner sc = new Scanner(System.in);
		int jobid;
		String jobtitle;
	    Transaction tx = s.beginTransaction();
	    System.out.println("Enter job id to find record");
	    jobid = sc.nextInt();
	    Object o = s.get(Job.class, new Integer(jobid));
	    Job obj = (Job)o;
	    obj.setJobid(jobid);
	    System.out.println("Enter job title");
	    jobtitle = sc.next();
	    obj.setJobtitle(jobtitle);
	    s.update(obj);
	    tx.commit();
	   
	}
	static void deleteOperation()
	{
		Scanner sc = new Scanner(System.in);
		int jobid;
		String jobtitle;
		Transaction tx = s.beginTransaction();
	    System.out.println("Enter job id to find record");
	    jobid = sc.nextInt();
	    Object o = s.get(Job.class, new Integer(jobid));
	    Job obj = (Job)o;
	    s.delete(obj);
	    tx.commit();
	   
	}
	static void closeConnection()
	{
		s.close();
	}
	public static void main(String[] args) {
		connection();
		insertOperation();
		selectOperation();

	}

}
