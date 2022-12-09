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

	public void deleteUserById(Integer id) {
		authenticationService.deleteUser(id);
	}

	public void addAuthor(Author author) {
		authorRepository.add(author);
	}

	public void addBookForAuthor(Integer authorId, Book book) {
		Author author = authorRepository.findById(authorId).get();
		if (author.getBooks() == null) {
			author.setBooks(new ArrayList<>());
		}
		author.getBooks().add(book);
		authorRepository.update(author);
	}

	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}

}
