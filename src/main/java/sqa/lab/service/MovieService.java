package sqa.lab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.repository.MovieRepository;
import sqa.lab.repository.ShowTimeRepository;
import sqa.lab.service.exception.MovieNotAvailableException;
import sqa.lab.service.exception.ShowtimeNotAvailableException;

public class MovieService {
    private MovieRepository movieRepo;

    private ShowTimeRepository showtimeRepo;

    public MovieService(MovieRepository movieRepository, ShowTimeRepository showTimeRepository) {
        this.movieRepo = movieRepository;
        this.showtimeRepo = showTimeRepository;
    }

    public boolean isMovieAvailableByDate(String movie, LocalDate today) throws MovieNotAvailableException {
        var listMovies = movieRepo.getAllMovieAvailableByDate(today);
        if (!listMovies.contains(movie)) {
            throw new MovieNotAvailableException("Does't have this Movie in This Day ");
        }
        return true;
    }

    public boolean isMovieAvailableByShowtime(String movie, LocalDate today, LocalDateTime showtime) throws ShowtimeNotAvailableException {
        var listshowtime = showtimeRepo.getAllShowTimesByMovieAndDate(movie, today);

        boolean isValidShowTime = listshowtime.contains(showtime);
        if (!isValidShowTime) {
            throw new ShowtimeNotAvailableException("This Movie dont have this Showtime");
        }
        return isValidShowTime;
    }
}
