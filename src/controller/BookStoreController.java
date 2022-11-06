package controller;

import entity.BookStore;
import exception.BadValueException;
import repository.Repository;
import view.BookStoreView;

import java.util.Optional;

public class BookStoreController {

    private Repository<BookStore> bookStoreRepository;
    private BookStoreView bookStoreView;

    public BookStoreController(Repository<BookStore> repository,BookStoreView bookStoreView) {
        this.bookStoreRepository=repository;
        this.bookStoreView=bookStoreView;
    }
    public BookStore addBookStore(BookStore bookStore) throws BadValueException{
        if(bookStore.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return bookStoreRepository.add(bookStore);
    }
    public BookStore updateBookStore(BookStore bookStore) throws BadValueException{
        if(bookStore.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return bookStoreRepository.update(bookStore);
    }
    public void deleteBookStoreById(int id) throws BadValueException {
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        bookStoreRepository.deleteById(id);
    }
    public void displayAll(){

        bookStoreView.displayBookstore(bookStoreRepository.findAll());
    }
    public void displayById(int id) throws BadValueException {
        Optional<BookStore> bookStoreOptional=bookStoreRepository.findById(id);
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        if(!bookStoreOptional.isEmpty()) {
            bookStoreView.displayBookStore(bookStoreOptional.get());
        }
    }

}
