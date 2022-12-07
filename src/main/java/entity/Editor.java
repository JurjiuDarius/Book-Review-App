package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "editor")
public class Editor extends Identifiable {

	@OneToMany(mappedBy = "editor", cascade = CascadeType.ALL)
	private List<Book> books;

	@Column(name = "establishment_year")
	private Integer establishmentYear;

}
