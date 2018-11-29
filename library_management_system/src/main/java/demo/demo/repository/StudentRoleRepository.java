package demo.demo.repository;

import demo.demo.model.StudentRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRoleRepository extends CrudRepository<StudentRole,String> {
}
