package com.moviebooking.search.service.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovieID")
    private Long id;

    private String title;
    private String genre;
    private String language;
    private String duration;
}
