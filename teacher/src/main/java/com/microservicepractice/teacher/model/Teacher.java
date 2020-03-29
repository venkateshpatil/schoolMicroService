package com.microservicepractice.teacher.model;

public class Teacher {
	 private int id;
	 private String name;
	 private double salary;
	 private int  age;
	 private int standard;
	 
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int id,String name, double salary, int age,int standard) {
		super();
		this.id= id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.standard = standard;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}

}
