package eu.ddqnov.springWebApp.repositories;

import eu.ddqnov.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
