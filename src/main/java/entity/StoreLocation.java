package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@Entity
@Table(name = "location")
public class StoreLocation extends Identifiable {

    private int id;
    private String city;
    private String country;
    private String county;
    private String address;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "store_id")
    private BookStore bookStore;

}
