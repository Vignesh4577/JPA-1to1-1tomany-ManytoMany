package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	 private IStudentRepository iStudentRepository;
	
	@Override
	public void addStudent(Student student) {
           iStudentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		 iStudentRepository.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		 iStudentRepository.deleteById(studentId);
	}

	@Override
	public Student getById(int studentId) {
		return null;
	}

	@Override
	public List<Student> getAll() {
		return iStudentRepository.findAll();
	}

	@Override
	public List<Student> getByDepartment(String department) {
		//return iStudentRepository.findByDepartment(department);
		return iStudentRepository.findStudsByDept(department);
	}

	@Override
	public List<Student> getByCity(String city) {
		//return iStudentRepository.findByAddressCity(city);
		return iStudentRepository.findStudsByCity(city);
	}

	@Override
	public List<Student> getByCityAndDepartment(String city, String department) {
		//return iStudentRepository.findByAddressCityAndDepartment(city, department);
		return  iStudentRepository.findStudsByCityDept(city, department);
	}

	@Override
	public List<Student> getByCityState(String city, String state) {
		return iStudentRepository.findStudsByCityState(city, state);
	}

}
