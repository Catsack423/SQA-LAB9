package sqa.lab.repository;

import java.time.LocalDateTime;
import java.util.Set;

public interface SeatRepository {
    
    public Set<String> getAllSeatAvailableByMovieAndShowTime (String movie,LocalDateTime showtime);
    public boolean isSeatAvailableBySeatId(String movie,LocalDateTime showtime,String seatId);
    public int addNewReserveFormMovieAndShowtimeAndSeatId(String movie,LocalDateTime showtime,String seatId);
}
