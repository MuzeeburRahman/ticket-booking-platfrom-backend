package com.sapient.moviecatalogservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.moviecatalogservice.dto.AllMovieResponse;
import com.sapient.moviecatalogservice.dto.MovieDto;
import com.sapient.moviecatalogservice.dto.ShowingDto;
import com.sapient.moviecatalogservice.exceptions.ResourceNotFoundException;
import com.sapient.moviecatalogservice.model.Movie;
import com.sapient.moviecatalogservice.repository.MovieRepository;

@Service
public class MovieCatalogService {
	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public AllMovieResponse getAllMovies() {
		//Retrieve all movies
		List<Movie> movies = movieRepository.findAll();
		
		//Map every movie object to MovieDto
		List<MovieDto> dto = movies.stream()
				.map(m -> MovieDto.builder().id(m.getId()).title(m.getTitle()).description(m.getDescription())
						.releaseDate(m.getReleaseDate()).runtime(m.getRuntime()).genre(m.getGenre())
						.language(m.getLanguage()).country(m.getCountry()).director(m.getDirector()).cast(m.getCast())
						.rating(m.getRating()).posterUrl(m.getPosterUrl()).trailerUrl(m.getTrailerUrl()).build())
				.collect(Collectors.toList());
		return AllMovieResponse.builder().movies(dto).build();
	}

	@Transactional(readOnly = true)
	public MovieDto getMovieById(String movieId) {
		//Retrieve movie
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("No movie found with id: " + movieId));
		
		//Map every show related to a movie to ShowingDto
		List<ShowingDto> shows = movie.getShows().stream()
				.map(m -> ShowingDto.builder().id(m.getId()).name(m.getTheater().getName())
						.location(m.getTheater().getLocation()).showTime(m.getShowTime()).totalSeats(m.getTotalSeats())
						.bookedSeats(m.getBookedSeats()).build())
				.collect(Collectors.toList());
		
		//Map every movie to MovieDto and return result
		return MovieDto.builder().id(movie.getId()).title(movie.getTitle()).description(movie.getDescription())
				.releaseDate(movie.getReleaseDate()).runtime(movie.getRuntime()).genre(movie.getGenre())
				.language(movie.getLanguage()).country(movie.getCountry()).director(movie.getDirector())
				.cast(movie.getCast()).rating(movie.getRating()).posterUrl(movie.getPosterUrl())
				.trailerUrl(movie.getTrailerUrl()).shows(shows).build();
	}

}
