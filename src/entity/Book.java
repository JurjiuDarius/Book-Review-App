package entity;

public class Book extends Identifiable {
    public int id;
    public String name;
    public String description;
    public String type;
    public String author;

    public int publicationYear;

    public Book(int id, String name, String description, String type, String author,int pubyear) {
        super(id);
        this.name = name;
        this.description = description;
        this.type = type;
        this.author = author;
        this.publicationYear = pubyear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int pubyear) {
        this.publicationYear = pubyear;
    }
}