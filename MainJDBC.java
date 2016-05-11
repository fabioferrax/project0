package it.uniroma3.model;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import it.uniroma3.persistence.StudenteDao;
import it.uniroma3.persistence.StudenteDaoJDBC;

public class MainJDBC {
	final static Logger logger = Logger.getLogger(MainJDBC.class);
	
	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.MARCH, 21); // // 21 marzo 1995
		Date date1 = cal.getTime();
		cal.set(1996, Calendar.APRIL, 12); // 12 aprile 1996
		Date date2 = cal.getTime();
		cal.set(1998, Calendar.OCTOBER, 1);  // 1 ottobre 1998
		Date date3 = cal.getTime();

		StudenteDao dao = new StudenteDaoJDBC();
		
		

		Studente studente1 = new Studente();
		studente1.setCognome("Rossi");
		studente1.setNome("Mario");
		studente1.setMatricola("00000001");
		studente1.setDataNascita(date1);
		
		Studente studente2 = new Studente();
		studente2.setCognome("Verdi");
		studente2.setNome("Anna");
		studente2.setMatricola("00000002");
		studente2.setDataNascita(date2);
		studente2.setIndirizzo(new Indirizzo("Torino","Via crispino"));
		
		Studente studente3 = new Studente();
		studente3.setCognome("Bianchi");
		studente3.setNome("Antonio");
		studente3.setMatricola("00000003");
		studente3.setDataNascita(date3);
		studente3.setIndirizzo(new Indirizzo("Roma","Via crispino"));

		dao.delete(studente1);
		dao.delete(studente2);
		dao.delete(studente3);
		//CREATE
		System.out.println("Inserisco 1");
		dao.save(studente1);
		System.out.println("Inserisco 2");
		dao.save(studente2);
		System.out.println("Inserisco 3");
		dao.save(studente3);

		//RETRIEVE
		System.out.println("Retrieve: matricola = 00000001");
		Studente studenteFromDb = dao.findByPrimaryKey("00000001");
		System.out.println(studenteFromDb);

		System.out.println("Retrieve: all");
		for(Studente s : dao.findAll()) {
			System.out.println(s);
		}

		//UPDATE
		System.out.println("Update: cambio nome a studente1");
		studente1.setNome("Antonella");
		dao.update(studente1);

		System.out.println("Retrieve: all");
		for(Studente s : dao.findAll()) {
			System.out.println(s);
		}

		//DELETE
		System.out.println("Delete: matricola = 00000001");
		dao.delete(studente1);

		System.out.println("Retrieve: all");
		for(Studente s : dao.findAll()) {
			System.out.println(s);
		}		
	}
}
