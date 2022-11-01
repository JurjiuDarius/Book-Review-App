package entity;

import java.util.List;

public abstract class User extends Identifiable {

    public String username;
    public int birth_year;
    public String education;
    public List<Book> list;

    public User(int userid, String username, int birth_year, String education, List<Book> list) {
        super(userid);
        this.username = username;
        this.birth_year = birth_year;
        this.education = education;
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

}

