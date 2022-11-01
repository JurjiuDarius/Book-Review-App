package view;

import entity.Book;

import java.util.List;

public class AuthorView {

	public void displayBook(Book author){
		System.out.println(author);
	}
	public void displayBooks(List<Book> authors){
		for(Book author:authors){
			System.out.println(author);
		}
	}

}
