package com.example.spring_test.Controller;


import com.example.spring_test.ApiResponce.ApiResponce;
import com.example.spring_test.Model.Teacher;
import com.example.spring_test.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        ArrayList<Teacher> teachers = teacherService.getTeachers();

        return ResponseEntity.status(400).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponce(message));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher Added!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id,
                                        @Valid @RequestBody Teacher teacher,
                                        Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponce(message));
        }

        boolean isUpdated = teacherService.updateTeacher(id,teacher);
        if (isUpdated){
            return ResponseEntity.status(200).body("Teacher Updated!!");
        }
        return ResponseEntity.status(400).body(new ApiResponce("Sorry ID is wrong"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){

        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("Teacher Deleted :(");
        }
        return ResponseEntity.status(400).body(new ApiResponce("Sorry ID is wrong"));

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findTeacher(@PathVariable int id){
        int index = teacherService.findTeacher(id);
        if (index == -1){
            return ResponseEntity.status(400).body(new ApiResponce("Sorry there isn't any Teachers with this ID"));
        }
        Teacher teacher = teacherService.getTeachers().get(index);
        return ResponseEntity.status(200).body(teacher);
    }

}
