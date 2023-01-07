package controller;

import entity.Author;
import exception.BadValueException;
import service.AuthorService;
import view.AuthorView;

public class AuthorController {

    private final AuthorService authorService;
    private final AuthorView authorView;

    public AuthorController(AuthorService authorService, AuthorView authorView) {
        this.authorService = authorService;
        this.authorView = authorView;
    }

    public Author addAuthor(Author author) throws BadValueException {
        if (author.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return authorService.add(author);
    }

    public Author updateAuthor(Author author) throws BadValueException {
        if (author.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return authorService.update(author);
    }

    public void deleteAuthorById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        authorService.deleteById(id);
    }

    public void displayAll() {

        authorView.displayAuthors(authorService.findAll());
    }

    public void displayById(int id) throws BadValueException {
        authorView.displayAuthor(authorService.findById(id));
    }

    public void authorsOlderThan(int year) {
        authorView.displayAuthors(authorService.authorsOlderThan(year));
    }

    public void authorsSortedByYear() {
        authorView.displayAuthors(authorService.authorsSortedByYear());
    }

    public void authorsSortedByName() {
        authorView.displayAuthors(authorService.authorsSortedByName());
    }

    public void authorsSortedByBooks() {
        authorView.displayAuthors(authorService.authorsSortedByBooks());
    }

}

