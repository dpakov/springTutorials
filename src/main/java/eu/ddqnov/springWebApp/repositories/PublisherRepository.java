package eu.ddqnov.springWebApp.repositories;

import eu.ddqnov.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
