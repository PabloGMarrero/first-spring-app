package unq.firstspringproject.springApp.repositories;

import org.springframework.data.repository.CrudRepository;
import unq.firstspringproject.springApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
