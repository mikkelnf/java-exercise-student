package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Student;

public abstract class StudentValidationUtil {
    public static Validation ageValidation(int minAge){
        return (Student s)->s.getAge()>=minAge;
    }

    public static Validation nameLengthValidation(int minLen,int maxLen){
        return (Student s)->s.getFullName().length()>=minLen && s.getFullName().length()<=maxLen;
    }
}
