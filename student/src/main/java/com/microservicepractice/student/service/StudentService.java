package com.microservicepractice.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicepractice.student.dao.StudentRepository;
import com.microservicepractice.student.model.Student;

@Service
public class StudentService {
	@Autowired StudentRepository  studentRepository;
	
	
	public List<Student>  addDummyDta(List<Student> studentList)
	{
		
		//return studentRepository.saveAll(studentList);	
		for(Student s : studentList)
		{
			studentRepository.saveAndFlush(s);
		}
		return getAllStudents();
	}
	
	public Student getStudent(int studentId)
	{	
		//to solve  No serializer found for class error  added the findById(studentId).orElse(null); instaed of 	return studentRepository.getOne(studentId);
		return studentRepository.findById(studentId).orElse(null);	
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student student)
	{
		return studentRepository.saveAndFlush(student);
	}
	
	
	public Student editStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	
	public void  deleteStudent(int studentId) {
		 studentRepository.deleteById(studentId);
	}
	
	public void  deleteAllStudents() {
		 studentRepository.deleteAll();
	}
	
	
	

}
