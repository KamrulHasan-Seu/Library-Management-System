package demo.demo.service;

import demo.demo.repository.BookRepository;
import demo.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
    public Iterable<Book> findAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(String id) {
        return bookRepository.findById(id);
    }
    public Book updateById(Book book){
        return bookRepository.save(book);
    }
    public void deleteById(String id){
        bookRepository.deleteById(id);
    }
}
