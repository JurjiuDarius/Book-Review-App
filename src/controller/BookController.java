package controller;

import entity.Book;
import exception.BadValueException;
import repository.Repository;
import view.BookView;

import java.util.Optional;

public class BookController {

	private Repository<Book> bookRepository;
	private BookView bookView;

	public BookController(Repository<Book> repository,BookView bookView) {
		this.bookRepository=repository;
		this.bookView=bookView;
	}

    public BookController() {

    }

	public Book addBook(Book book) throws BadValueException{
		if(book.id<0) {
			throw new BadValueException("Ids are positive numbers");
		}

		return bookRepository.add(book);
	}
	public Book updateBook(Book book) throws BadValueException{
		if(book.id<0) {
			throw new BadValueException("Ids are positive numbers");
		}
		return bookRepository.update(book);
	}
	public void deleteBookById(int id) throws BadValueException {
		if(id<0){
			throw new BadValueException("Ids are positive numbers");
		}
		bookRepository.deleteById(id);
	}
	public void displayAll(){

		bookView.displayBooks(bookRepository.findAll());
	}
	public void displayById(int id) throws BadValueException {
		Optional<Book> bookOptional=bookRepository.findById(id);
		if(id<0){
			throw new BadValueException("Ids are positive numbers");
		}
		if(!bookOptional.isEmpty()) {
			bookView.displayBook(bookOptional.get());
		}
	}

}
