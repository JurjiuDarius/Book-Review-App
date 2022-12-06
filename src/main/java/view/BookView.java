package view;

import entity.Book;

import java.util.List;

public class BookView {

	public void displayBook(Book book) {
		System.out.println(book);
	}

	public void displayBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}

}