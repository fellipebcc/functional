package br.edu.mg.unifal.domain;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String streetName;
    private String number;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private String country;

}
