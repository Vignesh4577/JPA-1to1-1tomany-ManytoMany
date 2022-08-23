package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Address;
import com.studentapp.model.Student;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringDatajpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetooneApplication.class, args);
	}

	@Autowired
	IStudentService iStudentService;

	@Override
	public void run(String... args) throws Exception {

		Address address = new Address("Davangere", "Karnataka");
		Address address1 = new Address("Naganur", "Karnataka");
		Address address2 = new Address("Mangalore", "Karnataka");
		Address address3 = new Address("udpi", "Karnataka");
		
		Student student = new Student("Alvas", "ME", address);
		Student student1 = new Student("MIET", "civil", address1);
		Student student2 = new Student("Yenapoya", "ISE", address2);
		Student student3 = new Student("BIET", "Textile", address3);
		

		// call the add method
		iStudentService.addStudent(student);
		iStudentService.addStudent(student1);
		iStudentService.addStudent(student2);
		iStudentService.addStudent(student3);

		System.out.println("*************************************************");
		System.out.println("By dept");
		iStudentService.getByDepartment("Textile").forEach(System.out::println);
		System.out.println("*************************************************");
		System.out.println("By city");
		iStudentService.getByCity("Davangere").forEach(System.out::println);
		System.out.println("*************************************************");
		System.out.println("By city and dept");
		iStudentService.getByCityAndDepartment("Naganur", "civil").forEach(System.out::println);
		System.out.println("*************************************************");

	}

}
