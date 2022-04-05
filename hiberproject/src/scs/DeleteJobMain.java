package scs;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteJobMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jobid;
		String jobtitle;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx = s.beginTransaction();
	    System.out.println("Enter job id to find record");
	    jobid = sc.nextInt();
	    Object o = s.get(Job.class, new Integer(jobid));
	    Job obj = (Job)o;
	    s.delete(obj);
	    tx.commit();
	    s.close();

	}

}
