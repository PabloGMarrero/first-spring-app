package unq.firstspringproject.springApp.repositories;

import org.springframework.data.repository.CrudRepository;
import unq.firstspringproject.springApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
