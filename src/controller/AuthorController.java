package controller;

import entity.Author;
import exception.BadValueException;
import repository.Repository;
import view.AuthorView;

import java.util.Optional;

public class AuthorController {

    private Repository<Author> authorRepository;
    private AuthorView authorView;

    public AuthorController(Repository<Author> repository,AuthorView authorView) {
        this.authorRepository=repository;
        this.authorView=authorView;
    }
    public Author addAuthor(Author author) throws BadValueException{
        if(author.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return authorRepository.add(author);
    }
    public Author updateAuthor(Author author) throws BadValueException{
        if(author.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return authorRepository.update(author);
    }
    public void deleteAuthorById(int id) throws BadValueException {
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        authorRepository.deleteById(id);
    }
    public void displayAll(){

        authorView.displayAuthors(authorRepository.findAll());
    }
    public void displayById(int id) throws BadValueException {
        Optional<Author> authorOptional=authorRepository.findById(id);
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        if(!authorOptional.isEmpty()) {
            authorView.displayAuthor(authorOptional.get());
        }
    }

}

