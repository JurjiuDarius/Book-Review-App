package SiteBook;

import entity.Admin;
import entity.Author;
import entity.Book;
import jakarta.persistence.*;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import repository.Repository;

import java.lang.module.Configuration;
import java.util.*;

public class Main {
//    @PersistenceUnit(name="BookReviewApp")
//    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("BookReviewApp");
        Repository<Author> authorRepository=new Repository<>(emf.createEntityManager(),"Author");
        Author author1 =Author.builder().education("Oxford").books(new ArrayList<>()).name("Patrick Rothfuss").username("user").birthYear(1920).build();
        Book book=Book.builder().name("Check cascade persistence").build();
        author1.getBooks().add(book);
        book.setAuthor(author1);
        authorRepository.add(author1);
    }

}



