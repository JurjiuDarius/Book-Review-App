package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book extends Identifiable {
    public int id;
    public String name;
    public String description;
    public String type;
    @ManyToOne()
    @JoinColumn(name="author_id")
    public Author author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    @Column(name="publication_year")
    public int publicationYear;

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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int pubYear) {
        this.publicationYear = pubYear;
    }
}
