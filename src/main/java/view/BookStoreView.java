package view;

import entity.BookStore;

import java.util.List;
import java.util.Scanner;

public class BookStoreView {

	public void displayBookStore(BookStore bookStore) {
		System.out.println(bookStore);
	}

	public void displayBookstore(List<BookStore> bookStores) {
		for (BookStore bookStore : bookStores) {
			System.out.println(bookStore);

		}
	}

	public BookStore newBookStore() {

		BookStore bookStore;
		Scanner menu = new Scanner(System.in);
		System.out.println("Enter Establishment Year: ");
		int establishmentYear = menu.nextInt();
		bookStore = BookStore.builder().establishmentYear(establishmentYear).build();
		return bookStore;

	}

}

