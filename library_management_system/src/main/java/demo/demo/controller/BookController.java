package demo.demo.controller;

import demo.demo.model.Book;
import demo.demo.service.BookService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "api/book")
@NoArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "all")
    @ResponseBody
    public ResponseEntity<?> getAllBook(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllBook());
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<?> getBookById(@PathVariable String id){

        Optional<Book> book = bookService.findBookById(id);

        if (book.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(book.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book does not exist for this id!");
        }

    }
    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<?> saveSeries(@RequestBody Book book){
        Optional<Book> OptionalBook= bookService.findBookById(book.getBookId());

        if (OptionalBook.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book already exist");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.saveBook(book));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Saved");
        }

    }
    @PutMapping(value = "update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateBook(@PathVariable String id,@RequestBody Book book){
        Optional<Book> optional = bookService.findBookById(id);

        if (!optional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Does not Exist");
        }

        optional.get().setName(book.getName());
        optional.get().setCategory(book.getCategory());

        try {
            Book bookById = bookService.updateById(optional.get());
            return ResponseEntity.status(HttpStatus.OK).body(bookById);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Updated");
        }
    }
    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteBook(@PathVariable String id) {

        Optional<Book> optionalBook= bookService.findBookById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Book Id!");
        }

        try {
            bookService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Deleted!");
        }

    }
}
