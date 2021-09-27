package model;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "student_Number")
    private String student_Number;

    @Column(name= "firstname")
    private String firstname;

    @Column(name= "surname")
    private String surname;

    @Column(name= "course_code")
    private String  course_code;

    @Column(name= "description")
    private String description;

    @Column(name= "grade")
    private int grade;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getStudent_Number() {
        return student_Number;
    }

    public void setStudent_Number(String student_Number) {
        this.student_Number = student_Number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(long id,String student_Number,String firstname,String surname,String course_code,String description,int grade) {
        this.student_Number = student_Number;
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.course_code = course_code;
        this.description = description;
        this.grade=grade;
    }

}
