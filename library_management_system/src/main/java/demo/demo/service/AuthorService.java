package demo.demo.service;

import demo.demo.model.Author;
import demo.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }
    public Iterable<Author> findAllAuthor()
    {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(String id) {
        return authorRepository.findById(id);
    }
    public Author updateById(Author author){
        return authorRepository.save(author);
    }
    public void deleteById(String id){
        authorRepository.deleteById(id);
    }
}
