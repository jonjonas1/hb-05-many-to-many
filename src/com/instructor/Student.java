package com.instructor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "student_name")
	private String firstName;
	@Column(name = "student_lastName")
	private String lastName;


	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE, 
					CascadeType.REFRESH,CascadeType.PERSIST })
	@JoinTable(
			name="course_student", //name of the table
			joinColumns=@JoinColumn(name="student_id"), //inside table course_id column
			inverseJoinColumns = @JoinColumn(name="course_id") //inverse:is the other side..the Course
			)
	// students will have list of courses
	private List<Course> courses;

	public List<Course> getCourse() {
		return courses;
	}

	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	public Student() {

	}

	// constructor w/o course
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// constructor with course
	public Student(String firstName, String lastName, List<Course> course) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + courses + "]";
	}

}
