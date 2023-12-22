package pl.edu.pja.sportsmap.persistence.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "object")
@Getter
@Setter
@NoArgsConstructor
public class SportObject {

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

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private SportObjectAddress adress;


}
