package sqa.lab.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public interface ShowTimeRepository {

    List<LocalDateTime> getAllShowTimesByMovieAndDate(String movie, LocalDate today);

}
