package demo.demo.controller;

import demo.demo.model.Department;
import demo.demo.service.DepartmentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "api/department")
@NoArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "all")
    @ResponseBody
    public ResponseEntity<?> getAllDepartment(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAllDepartment());
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<?> getDepartmentById(@PathVariable String id){

        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (departmentOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(departmentOptional.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department does not exist for this id!");
        }

    }
    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<?> saveDepartment(@RequestBody Department department){
        Optional<Department> OptionalDepartment= departmentService.findDepartmentById(department.getDeptId());

        if (OptionalDepartment.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department already exist");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.saveDepartment(department));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Saved");
        }

    }
    @PutMapping(value = "update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateBook(@PathVariable String id,@RequestBody Department department){
        Optional<Department> optional = departmentService.findDepartmentById(id);

        if (!optional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Does not Exist");
        }

        optional.get().setBatchNo(department.getBatchNo());
        optional.get().setDeptName(department.getDeptName());

        try {
            Department departmentById= departmentService.updateById(optional.get());
            return ResponseEntity.status(HttpStatus.OK).body(departmentById);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Updated");
        }
    }
    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {

        Optional<Department> optionalDepartment= departmentService.findDepartmentById(id);

        if (!optionalDepartment.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Department Id!");
        }

        try {
            departmentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Deleted!");
        }

    }
}
