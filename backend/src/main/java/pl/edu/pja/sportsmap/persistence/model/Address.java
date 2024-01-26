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
    @SequenceGenerator(name = "id_seq", sequenceName = "address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
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
