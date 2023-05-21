package com.example.spring_test.Service;


import com.example.spring_test.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public int findTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
