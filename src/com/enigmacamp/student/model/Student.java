package com.enigmacamp.student.model;

public class Student {
    private String fullName;
    private Integer age;

    private Major major;

    public Student(String fullName, Integer age, Major major) {
        this.fullName = fullName;
        this.age = age;
        this.major = major;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }
}
