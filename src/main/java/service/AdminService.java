package service;

import entity.Author;
import entity.Book;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.ArrayList;

@AllArgsConstructor
public class AdminService {

	private AuthenticationService authenticationService;
	private Repository<Author> authorRepository;

	private void deleteUserById(Integer id) {
		authenticationService.deleteUser(id);
	}

	private void addAuthor(Author author) {
		authorRepository.add(author);
	}

	private void addBookForAuthor(Integer authorId, Book book) {
		Author author = authorRepository.findById(authorId).get();
		if (author.getBooks() == null) {
			author.setBooks(new ArrayList<>());
		}
		author.getBooks().add(book);
		authorRepository.update(author);
	}

	private void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}

}
