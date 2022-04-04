package scs;


import org.hibernate.*;

import org.hibernate.cfg.*;

public class JobMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx = s.beginTransaction();
	    Job obj = new Job();
	    obj.setJobid(2);
	    obj.setJobtitle("Database Developer");
	    s.save(obj);
	    tx.commit();
	    s.close();

	}

}
