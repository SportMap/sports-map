package pl.edu.pja.sportsmap.persistence.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
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
