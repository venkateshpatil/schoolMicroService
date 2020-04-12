package com.microservicepractice.teacher.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicepractice.teacher.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
}
