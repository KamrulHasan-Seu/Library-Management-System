package demo.demo.controller;

import demo.demo.model.Book;
import demo.demo.model.Student;
import demo.demo.service.StudentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "api/student")
@NoArgsConstructor
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "all")
    @ResponseBody
    public ResponseEntity<?> getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudent());
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<?> getStudentById(@PathVariable String id){

        Optional<Student> student = studentService.findStudentById(id);

        if (student.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(student.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student does not exist for this id!");
        }

    }
    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        Optional<Student> OptionalStudent = studentService.findStudentById(student.getStudId());

        if (OptionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already exist");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent(student));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Saved");
        }

    }
    @PutMapping(value = "update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateStudent(@PathVariable String id,@RequestBody Student student){
        Optional<Student> optionalStudent = studentService.findStudentById(student.getStudId());

        if (!optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Does not Exist");
        }

        optionalStudent.get().setName(student.getName());
        optionalStudent.get().setAddress(student.getAddress());
        optionalStudent.get().setDept(student.getDept());
        optionalStudent.get().setEmail(student.getEmail());
        optionalStudent.get().setImage(student.getImage());

        try {
            Student student1 = studentService.updateById(optionalStudent.get());
            return ResponseEntity.status(HttpStatus.OK).body(student1);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Updated");
        }
    }
    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {

        Optional<Student> optionalStudent = studentService.findStudentById(id);

        if (!optionalStudent.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Student Id!");
        }

        try {
            studentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Deleted!");
        }

    }
}
