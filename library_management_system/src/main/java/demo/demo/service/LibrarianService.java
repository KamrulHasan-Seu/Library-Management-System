package demo.demo.service;

import demo.demo.repository.LibrarianRepository;
import demo.demo.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    public Librarian saveLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }
    public Iterable<Librarian> findAllLibrarian() {
        return librarianRepository.findAll();
    }

    public Optional<Librarian> findLibrarianById(String id) {
        return librarianRepository.findById(id);
    }
    public Librarian updateById(Librarian librarian){
        return librarianRepository.save(librarian);
    }
    public void deleteById(String id){
        librarianRepository.deleteById(id);
    }
}
