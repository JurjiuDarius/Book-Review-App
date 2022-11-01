package entity;

import java.util.List;

public class Author extends User {

	public Author(int userid, String username, int birth_year, String education, List<Book> list) {
		super(userid, username, birth_year, education, list);
	}

}
