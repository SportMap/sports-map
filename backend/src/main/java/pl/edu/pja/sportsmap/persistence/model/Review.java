package pl.edu.pja.sportsmap.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private SportComplex sportComplex;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "review_date")
    private LocalDate review_date;
}
