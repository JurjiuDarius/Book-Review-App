package entity;

import enums.AuthorityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "app_user")
public class User extends Identifiable {

    public String username;
    public String password;
    @Column(name = "birth_year")
    public Integer birthYear;
    @Enumerated(EnumType.STRING)
    public AuthorityEnum authority;

}

