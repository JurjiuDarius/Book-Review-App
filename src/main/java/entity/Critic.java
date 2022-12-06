package entity;

import java.util.List;

public class Critic extends User implements CriticInterface {

    public Critic(int id, String name, int birthYear, List<Book> list) {
        super(id, name, birthYear);
    }

    @Override
    public void add_review() {

    }

}
