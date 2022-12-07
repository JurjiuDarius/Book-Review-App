package view;

import entity.Author;

import java.util.List;

public class AuthorView {

	public void displayAuthor(Author author) {
		System.out.println(author);
	}

	public void displayAuthors(List<Author> authors) {
		for (Author author : authors) {
			System.out.println(author);
		}
	}

}
