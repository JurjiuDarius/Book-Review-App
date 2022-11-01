package entity;

import java.util.List;

public class Admin extends User {
    public Admin(int id, String name, int birth_year, String education, List<Book> list) {
        super(id, name, birth_year, education, list);
    }
}
