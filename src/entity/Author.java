package entity;

import java.util.List;

public class Author extends User {

	public Author(int userid, String username, int birthYear, String education, List<Book> list) {
		super(userid, username, birthYear, education, list);
	}

}
