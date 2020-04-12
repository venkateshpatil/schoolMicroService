package com.microservicepractice.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicepractice.student.model.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer>{

	
	
}
