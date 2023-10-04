package br.edu.mg.unifal.domain;

import br.edu.mg.unifal.enumerator.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDateTime birthdate;
    private Address address;

}
