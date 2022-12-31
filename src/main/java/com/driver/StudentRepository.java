package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepository {

    HashMap <String,Student> studentDatabase;
    HashMap <String,Teacher> teacherDatabase;
    HashMap <String,List<String>> studentTeacherPair;

    public StudentRepository(){
        studentDatabase = new HashMap<>();
        teacherDatabase = new HashMap<>();
        studentTeacherPair = new HashMap<>();
    }

    void addStudent(Student student){ studentDatabase.put(student.getName(), student); }

    void addTeacher(Teacher teacher){ teacherDatabase.put(teacher.getName(), teacher); }

    void addStudentTeacherPair(String student,String teacher){
        if(studentDatabase.containsKey(student) && teacherDatabase.containsKey(teacher)){
            List<String> students = new ArrayList<>();

            if(studentTeacherPair.containsKey(teacher)) students=studentTeacherPair.get(teacher);

            students.add(student);
            studentTeacherPair.put(teacher,students);
        }
    }

    Student getStudent(String name){
        if(studentDatabase.containsKey(name)) return studentDatabase.get(name);

        return null;
    }

    Teacher getTeacher(String name){
        if(teacherDatabase.containsKey(name)) return teacherDatabase.get(name);

        return null;
    }

    List<String> getStudentsByTeacher(String teacher){
        if(studentTeacherPair.containsKey(teacher)){
            return studentTeacherPair.get(teacher);
        }
        return null;
    }

    List<String> getAllStudents(){
        return new ArrayList<>(studentDatabase.keySet());
    }

    void deleteTeacher(String teacher){
        try{
            teacherDatabase.remove(teacher);

            for(String student : studentTeacherPair.get(teacher)){
                if(studentDatabase.containsKey(student)) studentDatabase.remove(student);
            }

            studentTeacherPair.remove(teacher);

        }
        catch(Exception e){

        }
    }

    void deleteAllTeachers(){
        try{
            teacherDatabase.clear();

            List<String> students = new ArrayList<>();

            for(String teacher : studentTeacherPair.keySet()){
                for(String student: studentTeacherPair.get(teacher)) students.add(student);
            }

            for(String student : students){
                if(studentDatabase.containsKey(student)) studentDatabase.remove(student);
            }

            studentTeacherPair.clear();

        }
        catch (Exception e){

        }
    }

}