package com.sapient.theatre.mgt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
	@Id
	private String id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 1500)
	private String description;

	@Column(nullable = false)
	private LocalDate releaseDate;

	@Column(nullable = false)
	private int runtime;

	@Column(nullable = false)
	private String genre;

	@Column(nullable = false)
	private String language;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String director;

	@Column(nullable = false)
	private String cast;

	@Column(nullable = false)
	private String rating;

	@Column(nullable = false)
	private String posterUrl;

	@Column(nullable = false)
	private String trailerUrl;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Showing> shows;

    public Movie(String number, String movieTitle, String action, String english, String s) {
    }
}
