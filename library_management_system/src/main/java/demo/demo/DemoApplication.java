package demo.demo;


import demo.demo.model.Librarian;
import demo.demo.service.BookService;
import demo.demo.service.DepartmentService;
import demo.demo.service.LibrarianService;
import demo.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =SpringApplication.run(DemoApplication.class, args);

        BookService bookService = run.getBean(BookService.class);
        DepartmentService departmentService = run.getBean(DepartmentService.class);
        LibrarianService librarianService = run.getBean(LibrarianService.class);
        StudentService studentService = run.getBean(StudentService.class);

        new InsertClass(bookService,departmentService,librarianService,studentService);
    }
}
