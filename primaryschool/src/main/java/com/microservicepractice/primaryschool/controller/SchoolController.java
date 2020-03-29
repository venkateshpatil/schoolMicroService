package com.microservicepractice.primaryschool.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicepractice.primaryschool.model.Standard;
import com.microservicepractice.primaryschool.model.Student;
import com.microservicepractice.primaryschool.model.Teacher;

@RequestMapping("school")
@RestController
public class SchoolController {

	private String schoolName = "Abcd";
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/schooolName")
	public String a() {

		return schoolName;
	}

	/*
	 * @GetMapping("/getClassInfo/{classNumber}") public Standard
	 * getClassInfo(@PathParam("classNumber") String classNumber1) {
	 */
	@GetMapping("/getClassInfo/{classId}")
	public Standard deleteStudent(@PathVariable("classId") int classId) {
		System.out.println(classId);
		Standard standard = new Standard();
		List<Student> allStudents = restTemplate.exchange(
				"http://localhost:8081/student/allStudents",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Student>>() {
				}).getBody();

		List<Teacher> allTeachers = restTemplate.exchange(
				"http://localhost:8082/teacher/allTeachers",
				HttpMethod.GET,
				null, 
				new ParameterizedTypeReference<List<Teacher>>() {
				}).getBody();

		for (Teacher t : allTeachers) {
			if (t.getStandard() == classId) {
				standard.setSchoolName(schoolName);
				standard.setClassTeacherName(t.getName());
				standard.setTeacher(t);
				break;
			}
		}
		int studentCount = 0;
		List<Student> sl = new ArrayList<Student>();
		for (Student s : allStudents) {
			if (s.getStandard() == classId) {
				studentCount++;
				sl.add(s);
			}
		}
		standard.setNumberofStudentsInclass(studentCount);
		standard.setStudents(sl);
		standard.setStandard(classId);
		return standard;

	}
}
