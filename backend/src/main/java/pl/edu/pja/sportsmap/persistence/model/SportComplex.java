package pl.edu.pja.sportsmap.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "sport_complexes")
@Getter
@Setter
@NoArgsConstructor
public class SportComplex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String website;

    @Column
    @Enumerated(EnumType.STRING)
    private SportComplexSurface surface;

    @Column
    @Enumerated(EnumType.STRING)
    private SportComplexCategory category;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column(name = "open_24_7")
    private boolean isOpen247;

    @ManyToOne
    private Address address;

    @Column
    private String photo;

    @Column(name = "phone_number")
    private String phoneNumber;
}
