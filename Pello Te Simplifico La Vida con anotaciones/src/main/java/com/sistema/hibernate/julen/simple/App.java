package com.sistema.hibernate.julen.simple;

import com.sistema.hibernate.julen.simple.dao.HibernateStudentDAO;
import com.sistema.hibernate.julen.simple.dao.StudentDAO;
import com.sistema.hibernate.julen.simple.models.Student;

import java.util.List;
import java.util.Scanner;

public class App {
	 
	public static void showAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.selectAll();
		System.out.println("--- STUDENT ----- table contents-----------");
		for (Student student : students) {
			System.out.println("Id: " + student.getId());
			System.out.println(" - Name: " + student.getName());
			System.out.println(" - Nota: " + student.getNota());
			System.out.println(" - Notificar esta PEDAZO de nota al correo "
					+ "electrónico : " + student.getEmail() + " ahora mismo, que esta"
							+ " en la carpa y pero lo verá.");
		}
		System.out.println("Total Students: " + students.size());
	}
	
	

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		String message = "";
		int nota = 0;
		StudentDAO studentDAO = new HibernateStudentDAO();
		
		System.out.println("Introducir nota para el pedazo alumno que tienes Julen: ");
		message = reader.nextLine();
		nota = Integer.parseInt(message);
	
		Student newStudent = new Student("Julen",nota,"soy-julen@hotmail.com");
		studentDAO.insert(newStudent);
		System.out.println("Inserted id: " + newStudent.getId());

		if (nota != 10) {
			
			System.out.println("La nota creo que es demasiado baja, se merece un 10");
			nota = 10;
			newStudent.setNota(nota);
			studentDAO.update(newStudent);
		}
		System.out.println("\nShow data after new insert/new update");
		showAll(studentDAO);
	}
}