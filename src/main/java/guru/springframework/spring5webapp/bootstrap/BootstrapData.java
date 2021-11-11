package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner
{
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;


  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
  {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override public void run(String... args) throws Exception
  {
    Publisher europa = new Publisher("EuropaPublisher", "MainStreet1", "London", 8090);
    publisherRepository.save(europa);

    Author ion = new Author("Ion", "Druta");
    Book horodiste = new Book("Horodiste", "B00012912Ro");

    ion.getBooks().add(horodiste);
    horodiste.getAuthors().add(ion);
    horodiste.setPublisher(europa);
    europa.getBooksPublished().add(horodiste);

    authorRepository.save(ion);
    bookRepository.save(horodiste);
    publisherRepository.save(europa);



    Author fedor = new Author("Fedor", "Dostoevsky");
    Book crime = new Book("Crime and Punishment", "C36456347Ru");

    fedor.getBooks().add(crime);
    crime.getAuthors().add(fedor);
    crime.setPublisher(europa);
    europa.getBooksPublished().add(crime);

    authorRepository.save(fedor);
    bookRepository.save(crime);
    publisherRepository.save(europa);

    System.out.println("Started in bootstrap");
    System.out.println("Number of books " + bookRepository.count());

    System.out.println("Number of books published: " + europa.getBooksPublished().size());

  }
}
