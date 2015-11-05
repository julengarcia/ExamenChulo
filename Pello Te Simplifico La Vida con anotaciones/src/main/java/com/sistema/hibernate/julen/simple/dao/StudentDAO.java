/**
 * 
 */
package com.sistema.hibernate.julen.simple.dao;

import java.util.List;

import com.sistema.hibernate.julen.simple.models.Student;

public interface StudentDAO {

	public List<Student> selectAll();

	public void insert(Student student);

	public void update(Student student);

}
