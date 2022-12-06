package SiteBook;

import entity.Author;
import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import repository.Repository;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
//    @PersistenceUnit(name="BookReviewApp")
//    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("BookReviewApp");
        EntityManager em= emf.createEntityManager();
        Author author1 =Author.builder().education("Oxford1").name("Sebi").birthYear(1920).build();
        em.getTransaction().begin();
        em.persist(author1);
        Author author2 =Author.builder().education("Inheritance works").name("Sebi2").birthYear(1920).username("Sebi2Username").build();
        em.persist(author2);
        em.getTransaction().commit();
        System.out.println("Finished main");

    }

}



