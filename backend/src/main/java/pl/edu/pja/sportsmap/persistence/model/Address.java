package pl.edu.pja.sportsmap.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String postalCode;

    @Column
    private String buildingNumber;

    @Column
    private String apartmentNumber;

    @Column
    private String city;
}
