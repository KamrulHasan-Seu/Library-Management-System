package demo.demo.controller;

import demo.demo.model.Author;
import demo.demo.model.Book;
import demo.demo.service.AuthorService;
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
public class Authorcontroller {
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "all")
    @ResponseBody
    public ResponseEntity<?> getAllAuthor(){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAllAuthor());
    }

    @GetMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<?> getAuthorById(@PathVariable String id){

        Optional<Author> author = authorService.findAuthorById(id);

        if (author.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(author.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Author does not exist for this id!");
        }

    }
    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<?> saveAuthor(@RequestBody Author author){
        Optional<Author> OptionalAuthor= authorService.findAuthorById(author.getAuthorId());

        if (OptionalAuthor.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Author already exist");
        }
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authorService.saveAuthor(author));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Saved");
        }

    }
    @PutMapping(value = "update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateAuthor(@PathVariable String id,@RequestBody Author author){
        Optional<Author> optional = authorService.findAuthorById(id);

        if (!optional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Does not Exist");
        }

        optional.get().setName(author.getName());

        try {
            Author authorById = authorService.updateById(optional.get());
            return ResponseEntity.status(HttpStatus.OK).body(authorById);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Updated");
        }
    }
    @DeleteMapping(value = "delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteAuthor(@PathVariable String id) {

        Optional<Author> optionalAuthor= authorService.findAuthorById(id);

        if (!optionalAuthor.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Author Id!");
        }

        try {
            authorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing Deleted!");
        }

    }
}
