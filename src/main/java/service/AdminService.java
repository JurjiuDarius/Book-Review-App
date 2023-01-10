package service;

import entity.*;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.ArrayList;

@AllArgsConstructor
public class AdminService {

    private AuthenticationService authenticationService;
    private Repository<Author> authorRepository;
    private Repository<BookStore> bookStoreRepository;
    private Repository<Book> bookRepository;
    private Repository<Editor> editorRepository;

    public void deleteUserById(Integer id) {
        authenticationService.deleteUser(id);
    }

    public void addAuthor(Author author) {
        authorRepository.add(author);
    }

    public void addBookForAuthor(Integer authorId, Integer bookId) {

        Author author = authorRepository.findById(authorId).get();
        Book book = bookRepository.findById(bookId).get();

        book.setAuthor(author);
        bookRepository.update(book);
    }

    public void addBookToBookStore(Integer bookId, Integer storeId) {
        BookStore bookStore = bookStoreRepository.findById(storeId).get();
        Book book = bookRepository.findById(bookId).get();
        if (book.getBookStores() == null) {
            book.setBookStores(new ArrayList<>());
        }
        if (bookStore.getBooks() == null) {
            bookStore.setBooks(new ArrayList<>());
        }
        book.getBookStores().add(bookStore);
        bookRepository.update(book);
    }

    public void addBookToEditor(Integer bookId, Integer editorId) {
        Editor editor = editorRepository.findById(editorId).get();
        Book book = bookRepository.findById(bookId).get();
        if (editor.getBooks() == null) {
            editor.setBooks(new ArrayList<>());
        }
        editor.getBooks().add(book);
        editorRepository.update(editor);

    }

}


