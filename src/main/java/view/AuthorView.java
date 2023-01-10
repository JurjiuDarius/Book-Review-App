package view;

import entity.Author;

import java.util.List;
import java.util.Scanner;

public class AuthorView {

    public void displayAuthor(Author author) {
        System.out.println(author);
    }

    public void displayAuthors(List<Author> authors) {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    public Author addAuthor() {
        Scanner authorMenu = new Scanner(System.in);
        Author author;
        System.out.println("Author name");
        String name = authorMenu.nextLine();
        System.out.println("Author education");
        String education = authorMenu.nextLine();
        System.out.println("Author birthyear");
        Integer birthyear = authorMenu.nextInt();

        author = Author.builder().name(name).education(education).birthYear(birthyear).build();
        return author;

    }

}
