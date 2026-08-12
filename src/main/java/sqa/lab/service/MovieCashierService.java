package sqa.lab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.repository.MovieRepository;
import sqa.lab.repository.SeatRepository;
import sqa.lab.repository.ShowTimeRepository;
import sqa.lab.service.api.TicketSellerService;

public class MovieCashierService implements TicketSellerService {
    private MovieRepository movieRepo;
    private ShowTimeRepository showtimeRepo;
    private SeatRepository seatRepo;

    MovieCashierService(MovieRepository mRepository, ShowTimeRepository showTimeRepository,
            SeatRepository seatRepository) {
        this.movieRepo = mRepository;
        this.showtimeRepo = showTimeRepository;
        this.seatRepo = seatRepository;

    }

    public void buyTicket(String movie, LocalDate today, LocalDateTime showtime, String seatId) {
        seatId = seatId.toUpperCase();
        var listMovies = movieRepo.getAllMovieAvailableByDate(today);

        boolean isMovieValid = listMovies.contains(movie);

        if (!isMovieValid) {
            throw new Error("Does't have this Movie in This Day ");
        }
        var listshowtime = showtimeRepo.getAllShowTimesByMovieAndDate(movie, today);

        boolean isValidShowTime = listshowtime.contains(showtime);

        if (!isValidShowTime) {
            throw new Error("This Movie dont have this Showtime");
        }

        if (!seatRepo.isSeatAvailableBySeatId(movie, showtime, seatId)) {
            throw new Error("This SeatId is already Reserved!!");
        }

        int id = seatRepo.addNewReserveFormMovieAndShowtimeAndSeatId(movie, showtime, seatId);
        System.out.println("Succeed " + id);
        return;
    }
}
