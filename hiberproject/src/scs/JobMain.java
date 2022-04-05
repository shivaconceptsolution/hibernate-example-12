package scs;


import org.hibernate.*;

import org.hibernate.cfg.*;
import java.util.Scanner;
public class JobMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jobid;
		String jobtitle;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx = s.beginTransaction();
	    System.out.println("Enter job id");
	    jobid = sc.nextInt();
	    System.out.println("Enter job title");
	    jobtitle = sc.next();
	    Job obj = new Job();
	    obj.setJobid(jobid);
	    obj.setJobtitle(jobtitle);
	    s.save(obj);
	    tx.commit();
	    s.close();

	}

}
