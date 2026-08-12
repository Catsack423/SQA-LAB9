package test9_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.lab.example.SeatDAO;
import sqa.lab.example.SeatReservation;

public class SeatReservationTest {
    private SeatReservation seatReservation;

    @BeforeEach
    void setUp() throws Exception{
        var mockdao = mock(SeatDAO.class);

        seatReservation = new SeatReservation(mockdao);

        when(mockdao.fetchAvailableSeats()).thenReturn(List.of("A1","A2","A3","A4"));
    }


    @Test
    void TestFecthSeat()throws Exception {
        assertEquals(true, seatReservation.checkSeatAvailability("A1"));
        //ไม่ว่าง
        assertNotEquals(true, seatReservation.checkSeatAvailability("A6"));
    }
}
