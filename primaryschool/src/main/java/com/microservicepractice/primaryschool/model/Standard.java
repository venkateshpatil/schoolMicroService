package com.microservicepractice.primaryschool.model;

import java.util.List;

public class Standard {
	private String schoolName = "abc";
	private int numberofStudentsInclass;
	private int standard;
	private String classTeacherName;
	private Teacher teacher;
	private List<Student> students;

	public Standard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Standard(String schoolName, int numberofStudentsInclass, int standard, String classTeacherName,
			Teacher teacher, List<Student> students) {
		super();
		this.schoolName = schoolName;
		this.numberofStudentsInclass = numberofStudentsInclass;
		this.standard = standard;
		this.classTeacherName = classTeacherName;
		this.teacher = teacher;
		this.students = students;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getNumberofStudentsInclass() {
		return numberofStudentsInclass;
	}

	public void setNumberofStudentsInclass(int numberofStudentsInclass) {
		this.numberofStudentsInclass = numberofStudentsInclass;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
