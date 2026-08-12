package sqa.lab.repository;

import java.time.LocalDate;
import java.util.List;

import sqa.lab.model.Movie;


public interface MoviePortal {

	List<Movie> getMovies(String location, LocalDate date);

}
