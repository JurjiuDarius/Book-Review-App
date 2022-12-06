package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="author")
public class Author extends User {
	private String name;
	private String education;
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
	private List<Book> books;
}
