package sqa.lab.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface MovieRepository {
    public List<String> getAllMovieAvailableByDate(LocalDate today);
}
