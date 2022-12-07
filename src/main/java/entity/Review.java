package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "review")
public class Review extends Identifiable {

	private String text;
	@Column(name = "publication_date")
	private Date publicationDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "critic_id")
	private User critic;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;

}
