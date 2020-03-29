package com.microservicepractice.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicepractice.student.model.Student;

@RequestMapping("student")
@RestController
public class StudentController {
	public static Map<Integer, Student> studentsDB = new HashMap<>();
	static
	{
		studentsDB.put(1, new Student(1, "aakash", 1, 6));
		studentsDB.put(2, new Student(2, "abhi", 1, 6));
		studentsDB.put(3, new Student(3, "appu", 1, 6));
		studentsDB.put(4, new Student(4, "salman", 2, 7));
		studentsDB.put(5, new Student(5, "raj", 2, 7));
		
	}

	@GetMapping("/{studentId}")
	public Object getStudent(@PathVariable("studentId") int studentId) {
		if((studentsDB.get(studentId)) != null)
		  return studentsDB.get(studentId);
		else 
			return "no student found ";
	}

	@GetMapping("/allStudents")
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(studentsDB.values());
	}

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		studentsDB.put(student.getRollNo(), student);
		return student;
	}

	@PutMapping("/editStudent")
	public String editStudent(@RequestBody Student student) {
		studentsDB.put(student.getRollNo(), student);
		return "student with student id " + student.getRollNo() + " is succefully edited.";
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public boolean deleteStudent(@PathVariable("studentId") int studentId) {
		studentsDB.remove(studentId);
		return true;
	}
}
