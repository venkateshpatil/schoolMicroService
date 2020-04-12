package com.microservicepractice.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservicepractice.teacher.dao.TeacherRepository;
import com.microservicepractice.teacher.model.Teacher;

@Service
public class TeacherService {
	@Autowired TeacherRepository teacherRepository;

	public List<Teacher> addDummyDta(List<Teacher> teacherList) {
		for (Teacher s : teacherList) {
			teacherRepository.saveAndFlush(s);
		}
		return getAllTeachers();
	}

	public Teacher getTeacher(int teacherId) {		
		//to solve  No serializer found for class error  added the findById(teacherId).orElse(null); instaed of //return teacherRepository.getOne(teacherId);;
		return teacherRepository.findById(teacherId).orElse(null);
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.saveAndFlush(teacher);
	}

	public Teacher editTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public void deleteTeacher(int teacherId) {
		teacherRepository.deleteById(teacherId);
	}

	public void deleteAllTeachers() {
		teacherRepository.deleteAll();
	}

}
