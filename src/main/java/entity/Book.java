package entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.mapping.Join;
import view.BookView;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="book")
public class Book extends Identifiable {
    public int id;
    public String name;
    public String description;
    public String type;
    @ManyToOne()
    @JoinColumn(name="author_id")
    private Author author;

    @Column(name="publication_year")
    private Integer publicationYear;

    @ManyToOne()
    @JoinColumn(name="editor_id")
    private Editor editor;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "distribution_contract",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "store_id"),
            }
    )
    List<BookStore> bookStores;


}
