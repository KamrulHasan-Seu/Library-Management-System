package demo.demo;

import demo.demo.model.*;
import demo.demo.repository.AuthorRepository;
import demo.demo.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InsertClass {
    private BookService bookService;
    private DepartmentService departmentService;
    private LibrarianService librarianService;
    private StudentService studentService;
    private AuthorService authorService;

    public InsertClass(BookService bookService, DepartmentService departmentService, LibrarianService librarianService, StudentService studentService, AuthorService authorService) {
        this.bookService = bookService;
        this.departmentService = departmentService;
        this.librarianService = librarianService;
        this.studentService = studentService;
        this.authorService = authorService;

        Set<Book> bookSet = new HashSet<>();
        Set<Author> authorList = new HashSet<>();

        Department department = new Department("CSE", "Computer Science and Engineering", 39);
        Category category = new Category("Programming","Programming");
        Student student = new Student("KamrulImage","Kamrul Hasan","Gazipur",
                "Kh317325@gmail.com","kamrul",department,RoleType.STUDENT,"Kamrul123",
                bookSet);
        Librarian librarian = new Librarian("ShamimImage","Md .shahmim","dhaka",
                "shamim@gmail.com","Shamim",RoleType.ADMIN,"Shamim123");

        Author author = new Author("Author1","Rajon");
        Book book = new Book("Java","Learn Java",authorList,category);

        bookSet.add(book);
        authorList.add(author);

        authorService.saveAuthor(author);
        bookService.saveBook(book);
        departmentService.saveDepartment(department);
        studentService.saveStudent(student);
        librarianService.saveLibrarian(librarian);



        System.out.println("Inserted Author:" + author);
        System.out.println("Inserted Dept :" + department);
        System.out.println("Inserted Student :" + student);
        System.out.println("Inserted Librarian :" + librarian);
        System.out.println("Inserted Book :" + book);
    }
}
