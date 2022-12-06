package entity;

import java.util.List;

public class Admin extends User {
    public Admin(int id, String name, int birthYear, List<Book> list) {
        super(id, name, birthYear);
    }
}
