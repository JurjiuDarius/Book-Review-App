package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.NamedStoredProcedureQueries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class User extends Identifiable{

    public String username;
    @Column(name="birth_year")
    public int birthYear;

    public User(int userid, String username, int birthYear) {
        super(userid);
        this.username = username;
        this.birthYear = birthYear;
    }

}

