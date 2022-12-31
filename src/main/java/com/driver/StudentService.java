package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    void addStudent(Student student){ studentRepository.addStudent(student);}

    void addTeacher(Teacher teacher){ studentRepository.addTeacher(teacher);}

    void addStudentTeacherPair(String student,String teacher){ studentRepository.addStudentTeacherPair(student,teacher);}

    Student getStudent(String name){ return studentRepository.getStudent(name); }

    Teacher getTeacher(String name){ return studentRepository.getTeacher(name); }

    List<String> getStudentsByTeacher(String teacher){ return studentRepository.getStudentsByTeacher(teacher); }

    List<String> getAllStudents(){ return studentRepository.getAllStudents(); }

    void deleteTeacher(String teacher){ studentRepository.deleteTeacher(teacher); }

    void deleteAllTeachers(){ studentRepository.deleteAllTeachers(); }

}