package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Model.Adres;
import com.denizturkmen.Util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
			
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			createEmployee(session);
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee is created with is::"+id);
		session.getTransaction().commit();
	}

	
	private static Employee getEmployee() {
		
		Employee employee = new Employee();
		employee.setEmployeeName("Deniz Türkmen");
		employee.setEmail("turkmen@hotmail.com");
		employee.setSalary(50000.0);
		employee.setDoj(new Date());
		
//		Employee employee1 = new Employee();
//		employee1.setEmployeeName("Murat");
//		employee1.setEmail("murat@hotmail.com");
//		employee1.setSalary(1000.0);
//		employee1.setDoj(new Date());

		
		
		Adres homeAdress = new Adres();
		homeAdress.setCity("Ankara");
		homeAdress.setState("Eryaman");
		homeAdress.setStreet("Metrowall");
		homeAdress.setPincode(5466L);
		
		Adres officeAdress = new Adres();
		officeAdress.setCity("Ankara1");
		officeAdress.setState("Eryaman1");
		officeAdress.setStreet("Metrowall1");
		officeAdress.setPincode(5466L);
		
		
		employee.setHomeAdress(homeAdress);
		employee.setOfficeAdress(officeAdress);
		
		/*
		 * Adres officalAdress = new Adres(); officalAdress.setCity("İstanbul");
		 * officalAdress.setState("Üsküdar");
		 * officalAdress.setStreet("Bilmem ne Mahllesi"); officalAdress.setPincode(12L);
		 * 
		 * employee.setHomeAdres(homeAdress); employee.setOfficeAdres(officalAdress);
		 */
		
		
		return employee;
	}
	
}
