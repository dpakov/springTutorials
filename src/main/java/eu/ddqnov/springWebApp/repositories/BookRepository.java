package eu.ddqnov.springWebApp.repositories;

import eu.ddqnov.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
