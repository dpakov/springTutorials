package eu.ddqnov.springWebApp.bootstrap;

import eu.ddqnov.springWebApp.domain.Author;
import eu.ddqnov.springWebApp.domain.Book;
import eu.ddqnov.springWebApp.domain.Publisher;
import eu.ddqnov.springWebApp.repositories.AuthorRepository;
import eu.ddqnov.springWebApp.repositories.BookRepository;
import eu.ddqnov.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    // dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        // initialize data
        Publisher publisher = new Publisher();
        publisher.setName("Ciela");
        publisher.setCity("Sofia");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
        Author isiromahov = new Author("Ivo", "Siromahov");
        Book umaikini = new Book("U maikinig", "123555");
        isiromahov.getBooks().add(umaikini);
        umaikini.getAuthors().add(isiromahov);

        umaikini.setPublisher(publisher);
        publisher.getBooks().add(umaikini);

        // save record in db
        authorRepository.save(isiromahov);
        bookRepository.save(umaikini);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "35985421");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Pubsliher books: " + publisher.getBooks().size());
    }
}
