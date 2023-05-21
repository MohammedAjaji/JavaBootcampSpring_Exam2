package com.example.spring_test.Controller;


import com.example.spring_test.ApiResponce.ApiResponce;
import com.example.spring_test.Model.Student;
import com.example.spring_test.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        ArrayList<Student> students = studentService.getStudents();

        return ResponseEntity.status(400).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponce(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student Added!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,
                                        @Valid @RequestBody Student student,
                                        Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponce(message));
        }

        boolean isUpdated = studentService.updateStudent(id,student);
        if (isUpdated){
            return ResponseEntity.status(200).body("Student Updated!!");
        }
        return ResponseEntity.status(400).body(new ApiResponce("Sorry ID is wrong"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){

        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("Student Deleted :(");
        }
        return ResponseEntity.status(400).body(new ApiResponce("Sorry ID is wrong"));

    }

    @GetMapping("/find/{name}")
    public ResponseEntity findStudent(@PathVariable String name){
         int index = studentService.findStudent(name);
         if (index == -1){
             return ResponseEntity.status(400).body(new ApiResponce("Sorry there isn't any student with this name"));
         }
         Student student = studentService.getStudents().get(index);
         return ResponseEntity.status(200).body(student);
    }
}
