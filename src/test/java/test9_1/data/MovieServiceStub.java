package test9_1.data;

import java.time.LocalDate;
import java.util.List;

import sqa.lab.model.Movie;
import sqa.lab.service.api.MovieService;

public class MovieServiceStub implements MovieService {
    @Override
    public List<Movie> requestMovies(String location, LocalDate date) {
        var e1 = new Movie("Avenger Endgame","VIP cinema");
        var e2 = new Movie("Avenger Doomday","IMAX");
        return List.of(e1,e2);
    }
}
