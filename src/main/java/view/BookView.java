package view;

import entity.Book;
import entity.BookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookView {

	public void displayBook(Book book) {
		System.out.println(book);
	}

	public void displayBooks(List<Book> books) {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public Book newBook(){
		Scanner bookMenu = new Scanner(System.in);
		Book book ;
		System.out.println("Book id:");
		Integer id = bookMenu.nextInt();
		System.out.println("Book name:");
		String name = bookMenu.nextLine();
		System.out.println("Book Description:");
		String description = bookMenu.nextLine();
		System.out.println("Book Type");
		String type = bookMenu.nextLine();
		System.out.println("Publication year");
		Integer publicationYear = bookMenu.nextInt();
		book = Book.builder().id(id).name(name).description(description).type(type).publicationYear(publicationYear).build();
		return book;
	}

}