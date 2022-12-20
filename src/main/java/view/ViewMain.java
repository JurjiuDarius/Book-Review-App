package view;

import controller.*;
import entity.*;
import enums.AuthorityEnum;
import exception.BadValueException;
import exception.EntityNotFoundException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.Repository;
import service.AdminService;
import service.AuthenticationService;
import service.CriticService;

import java.util.Scanner;

public class ViewMain {

	public static void main(String[] args) throws EntityNotFoundException, BadValueException {
		AuthorityEnum authorityEnum = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
		Repository<Author> authorRepository = new Repository<>(emf.createEntityManager(), "Author");
		Repository<Editor> editorRepository = new Repository<>(emf.createEntityManager(), "Editor");
		Repository<StoreLocation> storeLocationRepository = new Repository<>(emf.createEntityManager(), "StoreLocation");
		Repository<Book> bookRepository = new Repository<>(emf.createEntityManager(), "Book");
		Repository<Review> reviewRepository = new Repository<>(emf.createEntityManager(), "Review");
		Repository<BookStore> bookStoreRepository = new Repository<>(emf.createEntityManager(), "BookStore");
		Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");

		AuthenticationService authenticationService = new AuthenticationService(userRepository);
		AdminService adminService = new AdminService(authenticationService, authorRepository, storeLocationRepository, bookStoreRepository, bookRepository, editorRepository);
		CriticService criticService = new CriticService(bookRepository, reviewRepository, userRepository);

		BookView bookView = new BookView();
		AuthorView authorView = new AuthorView();
		BookStoreView bookStoreView = new BookStoreView();
		EditorView editorView = new EditorView();
		ReviewView reviewView = new ReviewView();
		StoreLocationView storeLocationView = new StoreLocationView();

		UserController userController = new UserController(authenticationService);
		CriticController criticController = new CriticController(criticService);
		AdminController adminController = new AdminController(adminService);
		BookController bookController = new BookController(bookRepository, bookView);
		AuthorController authorController = new AuthorController(authorRepository, authorView);
		BookStoreController bookStoreController = new BookStoreController(bookStoreRepository, bookStoreView);
		EditorController editorController = new EditorController(editorRepository, editorView);
		ReviewController reviewController = new ReviewController(reviewRepository, reviewView);
		StoreLocationController storeLocationController = new StoreLocationController(storeLocationRepository, storeLocationView);

		boolean isLoggedIn = false;
		;
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Username:");
			String username = input.nextLine();
			System.out.println("Password:");
			String password = input.nextLine();
			User user = userController.logIn(username, password);
			isLoggedIn = true;

			if (isLoggedIn) {
				switch (user.getAuthority()) {
					case ADMIN: {
						adminMenu(bookController, authorController, bookStoreController, criticController, editorController, reviewController, storeLocationController, adminController, bookView, authorView, bookStoreView, editorView);

						break;
					}
					case VIEWER: {
						userMenu(bookController, authorController, bookStoreController, criticController, editorController, reviewController, storeLocationController, adminController, bookView);
						break;
					}

					case CRITIC: {
						criticMenu(userController, bookController, authorController, bookStoreController, criticController, editorController, reviewController, storeLocationController, adminController, bookView);
						break;
					}

					default: {
						System.out.println("There is no user");
					}
				}

			}
		}
	}

	public static void adminMenu(BookController bookController, AuthorController authorController, BookStoreController
			bookStoreController, CriticController criticController, EditorController
			                             editorController, ReviewController reviewController, StoreLocationController
			                             storeLocationController, AdminController adminController, BookView bookView, AuthorView authorView,
	                             BookStoreView bookStoreView,
	                             EditorView editorView) {
		Scanner adminMenu = new Scanner(System.in);
		System.out.println("1. Display menu");
		System.out.println("2. Add Book for Author");
		System.out.println("3. Add Book to Bookstore");
		System.out.println("4. Add Book to editor");
		System.out.println("5. Delete User");
		System.out.println("6. Add Menu");
		System.out.println("6. Quit");
		int menu = 0;

		do {
			System.out.println("Enter command: ");
			menu = adminMenu.nextInt();

			switch (menu) {
				case 1:
					int case1;
					System.out.println("1. Display Books");
					System.out.print("2. Display Authors");
					System.out.println("3. Display Bookstores");
					System.out.println("4. Display Editors");
					System.out.println("5. Display Reviews");
					System.out.println("6. Display Store Locations");
					System.out.println("7. Back");
					case1 = adminMenu.nextInt();
					switch (case1) {

						case 1:
							System.out.println("Books: ");
							bookController.displayAll();
							break;
						case 2:
							System.out.println("Authors: ");
							authorController.displayAll();
							break;
						case 3:
							System.out.println("Book Stores: ");
							bookStoreController.displayAll();
							break;
						case 4:
							System.out.println("Editors: ");
							editorController.displayAll();
							break;
						case 5:
							System.out.println("Reviews: ");
							reviewController.displayAll();
							break;
						case 6:
							System.out.println("Store Locations: ");
							storeLocationController.displayAll();
							break;
						case 7:
							System.out.println("1. Display menu");
							System.out.println("2. Add Book for Author");
							System.out.println("3. Add Book to Bookstore");
							System.out.println("4. Add Book to editor");
							System.out.println("5. Delete User");
							System.out.println("6. Add Menu");
							System.out.println("6. Quit");
							break;
					}
					break;

				case 2:
					System.out.println("Author id for adding book: ");
					Integer authID = adminMenu.nextInt();
					System.out.println("Book id :");
					Integer bookId = adminMenu.nextInt();
					adminController.addBookForAuth(authID, bookId);
					System.out.println("Added");
					break;
				case 3:
					System.out.println("Book id: ");
					Integer bookid = adminMenu.nextInt();
					System.out.println("Book Store id: ");
					Integer bookStoreId = adminMenu.nextInt();
					adminController.addBookToBookstore(bookid, bookStoreId);
					System.out.println("Added book to book store");
					break;
				case 4:
					System.out.println("Book id: ");
					Integer bookID = adminMenu.nextInt();
					System.out.println("Editor id: ");
					Integer editorId = adminMenu.nextInt();
					adminController.addBookToEditor(bookID, editorId);
					System.out.println("Added book to Editor");
					break;

				case 5:
					System.out.println("User Id to delete");
					Integer id = adminMenu.nextInt();
					adminController.deleteUserByID(id);
					break;

				case 6:
					System.out.println("1. Add Book");
					System.out.println("2. Add Author");
					System.out.println("3. Add BookStore");
					System.out.println("4. Add Editors");
					System.out.println("5. Back");
					int case6;
					case6 = adminMenu.nextInt();
					switch (case6) {
						case 1:
							try {
								bookController.addBook(bookView.newBook());
							} catch (BadValueException e) {
								System.out.println(e);
							}
							break;
						case 2:
							try {
								authorController.addAuthor(authorView.addAuthor());
							} catch (BadValueException e) {
								System.out.println(e);
							}
							break;
						case 3:
							bookStoreView.newBookStore();
							break;
						case 4:
							editorView.newEditor();
							break;
						case 5:
							System.out.println("1. Display menu");
							System.out.println("2. Add Book for Author");
							System.out.println("3. Add Book to Bookstore");
							System.out.println("4. Add Book to editor");
							System.out.println("5. Delete User");
							System.out.println("6. Add Menu");
							System.out.println("6. Quit");
							break;

					}
					break;

			}

		} while (menu != 7);

	}

	public static void userMenu(BookController bookController, AuthorController authorController, BookStoreController
			bookStoreController, CriticController criticController, EditorController
			                            editorController, ReviewController reviewController, StoreLocationController
			                            storeLocationController, AdminController adminController, BookView bookView) throws BadValueException {
		Scanner userMenu = new Scanner(System.in);
		System.out.println("1. Display Books");
		System.out.print("2. Display Authors");
		System.out.println("3. Display Bookstores");
		System.out.println("4. Display Editors");
		System.out.println("5. Display Reviews");
		System.out.println("6. Display Store Locations");
		System.out.println("7. Quit");
		int um;
		do {
			um = userMenu.nextInt();
			switch (um) {
				case 1:
					System.out.println("Books: ");
					bookController.displayAll();
					break;
				case 2:
					System.out.println("Authors: ");
					authorController.displayAll();
					break;
				case 3:
					System.out.println("Book Stores: ");
					bookStoreController.displayAll();
					break;
				case 4:
					System.out.println("Editors: ");
					editorController.displayAll();
					break;
				case 5:
					System.out.println("Reviews: ");
					reviewController.displayAll();
					break;
				case 6:
					System.out.println("Store Locations: ");
					storeLocationController.displayAll();
					break;

			}

		} while (um != 7);

	}

	public static void criticMenu(UserController userController, BookController bookController, AuthorController authorController, BookStoreController
			bookStoreController, CriticController criticController, EditorController
			                              editorController, ReviewController reviewController, StoreLocationController
			                              storeLocationController, AdminController adminController, BookView bookView) throws BadValueException {

		Scanner criticMenu = new Scanner(System.in);
		System.out.println("1. Display menu");
		System.out.println("2. Add Review for Book");
		System.out.println("3. Quit");
		int cm;
		do {
			cm = criticMenu.nextInt();

			switch (cm) {
				case 1:
					int case1;
					System.out.println("1. Display Books");
					System.out.print("2. Display Authors");
					System.out.println("3. Display Bookstores");
					System.out.println("4. Display Editors");
					System.out.println("5. Display Reviews");
					System.out.println("6. Display Store Locations");
					System.out.println("7. Back");
					case1 = criticMenu.nextInt();
					switch (case1) {

						case 1:
							System.out.println("Books: ");
							bookController.displayAll();
							break;
						case 2:
							System.out.println("Authors: ");
							authorController.displayAll();
							break;
						case 3:
							System.out.println("Book Stores: ");
							bookStoreController.displayAll();
							break;
						case 4:
							System.out.println("Editors: ");
							editorController.displayAll();
							break;
						case 5:
							System.out.println("Reviews: ");
							reviewController.displayAll();
							break;
						case 6:
							System.out.println("Store Locations: ");
							storeLocationController.displayAll();
							break;
						case 7:
							System.out.println("1. Display menu");
							System.out.println("2. Add Review for Book");
							System.out.println("3. Quit");
							break;
					}
					break;

				case 2:

					System.out.println("Enter bookid: ");
					int bookID = criticMenu.nextInt();
					System.out.println("Enter Review: ");
					String rev = criticMenu.nextLine();
					criticController.addReview(userController.getCurrentUser(), bookID, rev);
					break;

			}
		} while (cm != 3);

	}

}

