package entity;

import java.util.List;

public class Editor extends Identifiable {

    public List<Book> list;

    public Editor(int id, List<Book> list) {
        super(id);
        this.list = list;
    }


    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
