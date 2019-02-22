package com.gce.spring5webapp;

import com.gce.spring5webapp.model.Author;
import com.gce.spring5webapp.model.Book;
import com.gce.spring5webapp.model.Publisher;
import com.gce.spring5webapp.repositories.AuthorRepository;
import com.gce.spring5webapp.repositories.BookRepository;
import com.gce.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Component
//public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
//    private AuthorRepository authorRepository;
//    private BookRepository bookRepository;
//
//    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//    }
//
//    private void initData() {
//        Author eric = new Author("Eric", "Evans");
//        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
//        eric.getBooks().add(ddd);
//        ddd.getAuthors().add(eric);
//
//        authorRepository.save(eric);
//        bookRepository.save(ddd);
//
//        Author rod = new Author("Rod", "Johnson");
//        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
//        rod.getBooks().add(noEJB);
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        initData();
//    }
//}

@Component
public class DevBootstrap implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Publisher publisherPaul = new Publisher("Paul", "San Francisco");
        Book ddd = new Book("Domain Driven Design", "1234", publisherPaul);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisherPaul);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Publisher publisherMark = new Publisher("Mark", "Los Angeles");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherMark);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisherMark);
        bookRepository.save(noEJB);


    }
}
