package guru.springframework.spring5webapp.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class StartUp implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public StartUp(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author madhu = new Author("Madhusudan", "Joshi");
		Book java = new Book("1234","Java");
		
		Author pintu = new Author("Pintu", "Joshi");
		Book spring = new Book("1235","Spring");
		
		
		madhu.getBooks().add(java);
		java.getAuthors().add(madhu);
		
		pintu.getBooks().add(java);
		spring.getAuthors().add(pintu);
		madhu.getBooks().add(spring);
		java.getAuthors().add(pintu);
		
		authorRepository.save(madhu);
		bookRepository.save(java);
		authorRepository.save(pintu);
		bookRepository.save(spring);
		
		Publisher sanskar = new Publisher("sansakr","nayapalli, bhubaneswar","bhubaneswar","odisha",768028);
		publisherRepository.save(sanskar);
		
		sanskar.getBooks().add(java);
		sanskar.getBooks().add(spring);
		
		System.out.println("inside start up class");
		System.out.println("number of authors : "+authorRepository.count());
		System.out.println("number of books :"+bookRepository.count());
		System.out.println("publisher count :"+publisherRepository.count());
	}
}
