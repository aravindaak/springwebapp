package com.simple.springwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.simple.springwebapp.models.Author;
import com.simple.springwebapp.models.Book;
import com.simple.springwebapp.models.Publisher;
import com.simple.springwebapp.repositories.AuthorRepository;
import com.simple.springwebapp.repositories.BookRepository;
import com.simple.springwebapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
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
		Publisher publisher = new Publisher();
        publisher.setName("ABC Publishers");
	    publisher.setCity("Chennai");
	    publisher.setState("Tamil Nadu");
	    
	    publisherRepository.save(publisher);
		
		
		Author eb = new Author("Enid", "Blyton");
		Book ff = new Book("Famous Five", "123123");
		eb.getBooks().add(ff);
		ff.getAuthors().add(eb);
		ff.setPublisher(publisher);
		publisher.getBooks().add(ff);
		
		authorRepository.save(eb);
		bookRepository.save(ff);
		
		
		Author jkr = new Author("J", "Rowling");
		Book hr = new Book("Harry Potter", "31234");
		
		jkr.getBooks().add(hr);
		hr.getAuthors().add(jkr);
		publisher.getBooks().add(hr);
		
		authorRepository.save(jkr);
		bookRepository.save(hr);
		publisherRepository.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books" + bookRepository.count());
		System.out.println("Number of Authors" + authorRepository.count());
		System.out.println("Number of Publishers" + publisher.getBooks().size());
		
	}
	
}
