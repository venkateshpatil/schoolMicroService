package com.microservicepractice.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicepractice.student.model.Student;
import com.microservicepractice.student.service.StudentService;


@RequestMapping("student")
@RestController
public class StudentController {
	@Autowired StudentService studentService;
	
	@PostMapping("/addDummyData")
	public List<Student> addAllDummyData() {		
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1, "aakash", 1, 6));
		studentList.add(new Student(2, "abhi", 1, 6));
		studentList.add(new Student(3, "appu", 1, 6));
		studentList.add(new Student(4, "salman", 2, 7));
		studentList.add(new Student(5, "raj", 2, 7));		
		return studentService.addDummyDta(studentList);		
	}
	
	
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);		
	}

	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
		//return new ArrayList<Student>(studentsDB.values());
	}

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {		
		return studentService.addStudent(student);
		/*
		 * studentsDB.put(student.getRollNo(), student); return student;
		 */
	}

	@PutMapping("/editStudent")
	public Student editStudent(@RequestBody Student student) {
		return studentService.editStudent(student);
		/*
		 * studentsDB.put(student.getRollNo(), student); return
		 * "student with student id " + student.getRollNo() + " is succefully edited.";
		 */}

	@DeleteMapping("/deleteStudent/{studentId}")
	public boolean  deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return true;		
		/*
		 * studentsDB.remove(studentId); return true;
		 */
	}
	
	@DeleteMapping("/deleteAllStudents")
	public boolean deleteAllStudents()
	{
		studentService.deleteAllStudents();
		return true;
	}
	
}
