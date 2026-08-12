package sqa.lab.service.api;

import java.time.LocalDate;
import java.util.List;

import sqa.lab.service.Movie;



/*
 * <<interface>> MovieService
 */
public interface MovieService {

	List<Movie> requestMovies(String location, LocalDate date);

}
