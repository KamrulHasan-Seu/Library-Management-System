package demo.demo.service;

import demo.demo.repository.DepartmentRepository;
import demo.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }
    public Iterable<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }
    public Department updateById(Department department){
        return departmentRepository.save(department);
    }
    public void deleteById(String id){
        departmentRepository.deleteById(id);
    }
}
