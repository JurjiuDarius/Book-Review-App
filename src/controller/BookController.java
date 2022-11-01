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
	public void deleteBookById(int id){
		bookRepository.deleteById(id);
	}
	public void displayAll(){
		bookView.displayBooks(bookRepository.findAll());
	}
	public void displayById(int id){
		Optional<Book> bookOptional=bookRepository.findById(id);
		if(!bookOptional.isEmpty()) {
			bookView.displayBook(bookOptional.get());
		}
	}

}
