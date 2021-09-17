package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Sep 16, 2021
 */

@Entity
@Table(name="StudentRecords")
public class StudentRecords {
	
	//attributes
	@Id
	@GeneratedValue
	@Column(name="STUDENTId")
	private int studentId;
	
	@Column(name="STUDENTNAME")
	private String studentName;
	
	@Column(name="COURSENAME")
	private String courseName;
	
	//default constructor
	public StudentRecords() {
		super();
		
	}

	//none default constructor

	public StudentRecords(int studentId, String studentName, String courseName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "StudentRecords [studentId=" + studentId + ", studentName=" + studentName + ", courseName=" + courseName
				+ "]";
	}

	//getters and setters
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


}
