package com.sistema.hibernate.julen.simple.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.julen.simple.HibernateSession;
import com.sistema.hibernate.julen.simple.models.Student;;

/**
 * Hibernate specific Customer DAO
 * 
 * 
 @author Eugenia Pérez Martínez
 */
public class HibernateStudentDAO implements StudentDAO {
	/*
	 * selects one customer by Id
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	public Student selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Student customer = (Student) session.get(Student.class, id);
		session.close();
		return customer;
	}

	/*
	 * retrieves all customers from db
	 * 
	 * @return List of customers
	 */
	public List<Student> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Student> customers = session.createCriteria(Student.class)
				.list();
		session.close();
		return customers;
	}

	/*
	 * inserts a new customer in database retrieves generated id and sets to
	 * customer instance
	 * 
	 * @param new customer
	 */
	public void insert(Student customer) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(customer);
		customer.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates customer
	 * 
	 * @param customer to update
	 */
	public void update(Student customer) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(customer);
		session.getTransaction().commit();

		session.close();
	}

	/*
	 * delete given customer
	 * 
	 * @param customer to delete
	 */
	public void delete(Student customer) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}
}
