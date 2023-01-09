package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@ToString(exclude = "books")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "book_store")
public class BookStore extends Identifiable {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "distribution_contract",
            joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    List<Book> books;
    private int id;
    private int establishmentYear;

    private String name;


}
