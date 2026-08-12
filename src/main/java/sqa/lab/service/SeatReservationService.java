package sqa.lab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.repository.SeatRepository;
import sqa.lab.service.exception.ShowtimeNotAvailableException;

public class SeatReservationService {
    private SeatRepository seatRepo;
    private MovieService movieService;

    public SeatReservationService(SeatRepository seatRepository,MovieService movieService) {
        this.seatRepo = seatRepository;
        this.movieService = movieService;
    }

    public boolean isSeatAvailable(String movie, LocalDate day, LocalDateTime showtime, String seatId) throws ShowtimeNotAvailableException {
        movieService.isMovieAvailableByShowtime(movie, day, showtime);
        seatId = seatId.toUpperCase();
        return seatRepo.isSeatAvailableByMovieAndShowTimeAndSeatId(movie, showtime, seatId);
    }

    public int addSeatReservation(String movie, LocalDateTime showtime, String seatId, LocalDate day) throws ShowtimeNotAvailableException {
        seatId = seatId.toUpperCase();
        movieService.isMovieAvailableByShowtime(movie, day, showtime);
        return seatRepo.addNewReserveFormMovieAndShowtimeAndSeatId(movie, showtime, seatId);
    }
}
