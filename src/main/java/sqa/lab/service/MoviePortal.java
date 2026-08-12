package sqa.lab.service;

import java.time.LocalDate;
import java.util.List;

/*
 * <<external>> MoviePortal
 */
public interface MoviePortal {

	List<Movie> getMovies(String location, LocalDate date);

}
