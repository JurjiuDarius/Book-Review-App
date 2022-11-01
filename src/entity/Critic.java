package entity;

import java.util.List;

public class Critic extends User implements CriticInterface {

    public Critic(int id, String name, int birth_year, String education, List<Book> list) {
        super(id, name, birth_year, education, list);
    }

    @Override
    public void add_review() {

    }

}
