package test;

import controller.BookController;
import entity.Book;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.BookView;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookControllerTest {

	Repository<Book> bookRepository = new Repository<Book>();
	BookView bookView = new BookView();
	BookController bookController;

	@BeforeAll
	private void setup() {
		bookController = new BookController(bookRepository, bookView);
	}

	@Test
	void testAdd() {
		Book book = new Book(1, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.addBook(book);
		} catch (BadValueException e) {
			assert (false);
		}
	}

	@Test
	void testAddFail() {
		Book book = new Book(-11, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.addBook(book);

		} catch (BadValueException e) {
			assert (e.getClass().equals(BadValueException.class));
		}
	}

	@Test
	void testUpdateFail() {
		Book book = new Book(1, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		Book updateBook = new Book(1, "new title", "", "", "", 1980);
		try {
			bookController.addBook(book);

		} catch (BadValueException e) {
			assert (false);
		}
	}

	@Test
	void testDelete() {
		Book book = new Book(1, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.deleteBookById(1);
		} catch (BadValueException e) {
			assert (false);
		}
	}

	@Test
	void testDeleteFail() {
		Book book = new Book(-2, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.deleteBookById(-2);

		} catch (BadValueException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	void displayByIdTest() {
		Book book = new Book(1, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.displayById(1);
		} catch (BadValueException e) {
			assert (false);
		}
	}

	@Test
	void displayByIdFail() {
		Book book = new Book(-2, "Gone With The wind", "Romantic book", "Classics", "Emily Bronte", 1876);
		try {
			bookController.displayById(-2);
		} catch (BadValueException e) {
			throw new RuntimeException(e);
		}
	}
}


