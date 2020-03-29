package com.microservicepractice.teacher.controller;

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

import com.microservicepractice.teacher.model.Teacher;
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private static Map<Integer,Teacher> teachersDB = new HashMap<>();
	static
	{
		teachersDB.put(1, new Teacher(1, "Teacher1", 10000, 35, 1));
		teachersDB.put(2, new Teacher(2, "Teacher2", 20000, 45, 2));		
	}
	
	@GetMapping("/allTeachers")
	public static List<Teacher> getAllTeachers()
	{
		return new ArrayList<Teacher>(teachersDB.values());
	}	
	
	@GetMapping("/{teacherId}")
	public Teacher getTeacher(@PathVariable("teacherId") int teacherId)
	{
		return teachersDB.get(teacherId);
	}
	
	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher)
	{
		teachersDB.put(teacher.getId(), teacher);
		return teacher;
	}
	
	@PutMapping("/editTeacher")
	public String editTeacher(@RequestBody Teacher teacher)
	{
		teachersDB.put(teacher.getId(), teacher);
		return "tecaher with  id "+teacher.getId()+" is succefully edited.";
	}
	
	@DeleteMapping("/deleteTeacher/{teacherId}")
	public boolean deleteTeacher(@PathVariable("teacherId") int teacherId)
	{
		teachersDB.remove(teacherId);
		return true;		
	}

}
