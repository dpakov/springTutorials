package eu.ddqnov.springWebApp.bootstrap;

import eu.ddqnov.springWebApp.domain.Author;
import eu.ddqnov.springWebApp.domain.Book;
import eu.ddqnov.springWebApp.repositories.AuthorRepository;
import eu.ddqnov.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    // dependency injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // initialize data
        Author isiromahov = new Author("Ivo", "Siromahov");
        Book umaikini = new Book("U maikinig", "123555");
        isiromahov.getBooks().add(umaikini);
        umaikini.getAuthors().add(isiromahov);

        // save record in db
        authorRepository.save(isiromahov);
        bookRepository.save(umaikini);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "35985421");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
