package demo.demo.service;

import demo.demo.repository.StudentRepository;
import demo.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Iterable<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(String id) {
        return studentRepository.findById(id);
    }
    public Student updateById(Student student){
        return studentRepository.save(student);
    }
    public void deleteById(String id){
        studentRepository.deleteById(id);
    }
}
