package com.cagdas.crudDemo;

import com.cagdas.crudDemo.dao.StudentDAO;
import com.cagdas.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);

	}



	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=10;

		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);

		Student myStudent=studentDAO.findById(studentId);
		System.out.println("Updating Student...");

		myStudent.setFirstName("Cagdas");
		studentDAO.update(myStudent);

		System.out.println("Updated student: "+myStudent);

	}

	private void queryForStudentsByName(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByName("Sevgi");

		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);

		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();

		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Daffy","Duck","daffy@outlook.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		int theId=tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);
		Student myStudent=studentDAO.findById(theId);
		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student tempStudent1=new Student("Sevgi","Ciplak","cagdasciplak@outlook.com");
		Student tempStudent2=new Student("Irem","Ciplak","gizemciplak@outlook.com");
		Student tempStudent3=new Student("Gizem","Ciplak","iremciplak@outlook.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student tempStudent=new Student("Ali","Ciplak","aliciplak@outlook.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
