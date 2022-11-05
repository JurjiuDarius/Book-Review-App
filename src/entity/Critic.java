package entity;

import java.util.List;

public class Critic extends User implements CriticInterface {

    public Critic(int id, String name, int birthYear, String education, List<Book> list) {
        super(id, name, birthYear, education, list);
    }

    @Override
    public void add_review() {

    }

}
