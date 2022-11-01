package controller;

import entity.Book;
import repository.Repository;
import view.BookView;

import java.util.Optional;

public class BookController {

	private Repository<Book> bookRepository;
	private BookView bookView;

	public BookController() {
		bookRepository=new Repository<>();
		bookView=new BookView();
	}
	public Book addBook(Book book){
		return bookRepository.add(book);
	}
	public Book updateBook(Book book){
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
