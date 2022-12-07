package view;

import entity.BookStore;

import java.util.List;

public class BookStoreView {

	public void displayBookStore(BookStore bookStore) {
		System.out.println(bookStore);
	}

	public void displayBookstore(List<BookStore> bookStores) {
		for (BookStore bookStore : bookStores) {
			System.out.println(bookStore);
		}
	}

}

