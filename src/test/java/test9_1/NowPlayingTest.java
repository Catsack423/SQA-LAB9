package test9_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.lab.service.NowPlaying;
import sqa.lab.service.api.MovieService;
import test9_1.data.MovieServiceStub;

public class NowPlayingTest {
    private NowPlaying nowPlaying;
    private MovieService movieService;
    @BeforeEach
    public void setup(){
        MovieService movieService = new MovieServiceStub();
        nowPlaying = new NowPlaying(movieService);
    }
    /*
	 * data in stub
	 * var e1 = new Movie("Avenger Endgame","VIP cinema");
	 * var e2 = new Movie("Avenger Doomday","IMAX");
	 */
    @Test
    void checkIMAX(){
        assertEquals(List.of("Avenger Doomday"), nowPlaying.getNowPlayingByCinemaType(null, null, "IMAX"));
    }


     @Test
    void checkVIPcinema(){
        assertEquals(List.of("Avenger Endgame"), nowPlaying.getNowPlayingByCinemaType(null, null, "VIP cinema"));
    }
}
