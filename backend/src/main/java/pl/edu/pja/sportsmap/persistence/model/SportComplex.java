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
    private String surface;

    @Column
    private String category;

    @Column
    private String coordinates;

    @Column
    private String open247;

    @ManyToOne
    private Address address;
}
