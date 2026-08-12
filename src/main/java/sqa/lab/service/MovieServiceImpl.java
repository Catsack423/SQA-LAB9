package sqa.lab.service;

import java.time.LocalDate;
import java.util.List;

import sqa.lab.service.api.MovieService;

public class MovieServiceImpl implements MovieService {

	private MoviePortal moviePortal;

	public MovieServiceImpl(MoviePortal moviePortal) {
		this.moviePortal = moviePortal;
	}

	@Override
	public List<Movie> requestMovies(String location, LocalDate date) {
		return moviePortal.getMovies(location, date);
	}

}
