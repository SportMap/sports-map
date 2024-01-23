package pl.edu.pja.sportsmap.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "opening_hours")
public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalTime openingTime;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm a z")
    private LocalTime closingTime;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private DayOfWeek dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "sport_complex_id")
    private SportComplex sportComplex;
}
