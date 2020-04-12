package com.microservicepractice.teacher.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicepractice.teacher.model.Teacher;
import com.microservicepractice.teacher.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired TeacherService teacherService;

	@PostMapping("/addDummyData")
	public List<Teacher> addAllDummyData() {
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(new Teacher(1, "Teacher1", 10000, 35, 1));
		teacherList.add(new Teacher(2, "Teacher2", 20000, 45, 2));
		return teacherService.addDummyDta(teacherList);
	}

	@GetMapping("/allTeachers")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	@GetMapping("/{teacherId}")
	public Teacher getTeacher(@PathVariable("teacherId") int teacherId) {
		return teacherService.getTeacher(teacherId);
	}

	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}

	@PutMapping("/editTeacher")
	public String editTeacher(@RequestBody Teacher teacher) {
		teacherService.editTeacher(teacher);
		return "tecaher with  id " + teacher.getId() + " is succefully edited.";
	}

	@DeleteMapping("/deleteTeacher/{teacherId}")
	public boolean deleteTeacher(@PathVariable("teacherId") int teacherId) {
		teacherService.deleteTeacher(teacherId);
		return true;
	}

	@DeleteMapping("/deleteAllTeachers")
	public boolean deleteAllTeachers() {
		teacherService.deleteAllTeachers();
		return true;
	}

}
