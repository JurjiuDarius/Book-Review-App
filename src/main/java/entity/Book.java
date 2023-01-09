package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@ToString(exclude = "bookStores")
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "book")
@AllArgsConstructor
public class Book extends Identifiable {

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(
            name = "distribution_contract",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "store_id"),
            }
    )
    List<BookStore> bookStores;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Review> reviews;
    private int id;
    private String name;
    private String description;
    private String type;
    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "publication_year")
    private Integer publicationYear;
    @ManyToOne()
    @JoinColumn(name = "editor_id")
    private Editor editor;

}
