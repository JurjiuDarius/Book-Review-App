package entity;

import java.util.List;

public abstract class User extends Identifiable {

    public String username;
    public int birthYear;
    public String education;
    public List<Book> list;

    public User(int userid, String username, int birthYear, String education, List<Book> list) {
        super(userid);
        this.username = username;
        this.birthYear = birthYear;
        this.education = education;
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
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

