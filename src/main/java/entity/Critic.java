package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="author")
public class Critic extends User implements CriticInterface {

    @Override
    public void add_review() {

    }

}
