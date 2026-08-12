package sqa.lab.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import sqa.lab.model.Movie;
import sqa.lab.service.api.MovieService;

public class NowPlaying {
	
	private MovieService movieService;

	public NowPlaying(MovieService movieService) {
		this.movieService = movieService;
	}

	public List<String> getNowPlaying(String location, LocalDate date) {
		return toTitles(movieService.requestMovies(location, date));
	}

	public List<String> getNowPlayingByCinemaType(String location, LocalDate date, String cinemaType) {
		List<Movie> movies = movieService.requestMovies(location, date);
		List<Movie> filtered = movies.stream()
				.filter(movie -> movie.getCinemaType().equalsIgnoreCase(cinemaType))
				.collect(Collectors.toList());
		return toTitles(filtered);
	}

	private List<String> toTitles(List<Movie> movies) {
		return movies.stream()
				.map((movie) -> {
					return movie.getTitle();
				})
				.collect(Collectors.toList());
	}

}
