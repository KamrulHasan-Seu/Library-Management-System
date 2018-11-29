package demo.demo;

import demo.demo.model.Book;
import demo.demo.model.Department;
import demo.demo.model.Librarian;
import demo.demo.model.Student;
import demo.demo.service.BookService;
import demo.demo.service.DepartmentService;
import demo.demo.service.LibrarianService;
import demo.demo.service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InsertClass {
    private BookService bookService;
    private DepartmentService departmentService;
    private LibrarianService librarianService;
    private StudentService studentService;

    public InsertClass(BookService bookService, DepartmentService departmentService,
                       LibrarianService librarianService, StudentService studentService) {
        this.bookService = bookService;
        this.departmentService = departmentService;
        this.librarianService = librarianService;
        this.studentService = studentService;

        Set<Book> bookSet = new HashSet<>();

        Department department = new Department("CSE", "Computer Science and Engineering", 39);
        Student student = new Student("Kamrul", "KamrulImage", "Kamrul Hasan", "Mouchak,Kaliakoir,Gazipur",
                "kh317325@gmail.com", department, bookSet);
        Librarian librarian = new Librarian("Shamim", "Md Shamim", "MdShamim@gmail.com");
        Book book = new Book("Java", "Learn with java", "Programming");


        bookService.saveBook(book);
        departmentService.saveDepartment(department);
        studentService.saveStudent(student);
        librarianService.saveLibrarian(librarian);

        bookSet.add(book);

        System.out.println("Inserted Dept :" + department);
        System.out.println("Inserted Student :" + student);
        System.out.println("Inserted Librarian :" + librarian);
        System.out.println("Inserted Book :" + book);
    }

}
