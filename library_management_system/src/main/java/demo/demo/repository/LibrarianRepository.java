package demo.demo.repository;

import demo.demo.model.Librarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends CrudRepository<Librarian,String> {
}
