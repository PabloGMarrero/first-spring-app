package unq.firstspringproject.springApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import unq.firstspringproject.springApp.domain.Author;
import unq.firstspringproject.springApp.domain.Book;
import unq.firstspringproject.springApp.domain.Publisher;
import unq.firstspringproject.springApp.repositories.AuthorRepository;
import unq.firstspringproject.springApp.repositories.BookRepository;
import unq.firstspringproject.springApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author edgar = new Author("Edgar Allan", "Poe");
        Author king = new Author("Stephen", "King");
        Book it = new Book("IT", "9788497593793");
        Book theBlackCat = new Book("The Black Cat", "9780140954067");
        edgar.addBook(theBlackCat);
        king.addBook(it);


        Publisher aPublisher = new Publisher("Publisher1", "Blabla");
        publisherRepository.save(aPublisher);

        theBlackCat.setPublisher(aPublisher);
        publisherRepository.save(aPublisher);

        it.setPublisher(aPublisher);
        aPublisher.addBook(theBlackCat);
        aPublisher.addBook(it);

        authorRepository.save(king);
        authorRepository.save(edgar);
        bookRepository.save(theBlackCat);
        bookRepository.save(it);
        publisherRepository.save(aPublisher);

        System.out.println("Starting...");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publishers number of books: " + aPublisher.getBooks().size() );
    }
}
