package test9_2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqa.lab.example.GateCheckin;
import sqa.lab.example.TicketCounter;

public class GateCheckinTest {
    private GateCheckin gateCheckin;
    private TicketCounter ticketCounterMock;

    @BeforeEach
    void setup() {
        ticketCounterMock = mock(TicketCounter.class);
        gateCheckin = new GateCheckin(ticketCounterMock);
    }

    @Test
    void checkinValid_newTicket() {
        gateCheckin.customerEntry(1);

        verify(ticketCounterMock).changeTicketStatus(true);
        assertTrue(gateCheckin.getPassengersOnBoard().contains(1));
    }

    @Test
    void checkinInvalid_duplicateTicket() {
        gateCheckin.customerEntry(1);
        gateCheckin.customerEntry(1);

        verify(ticketCounterMock, times(1)).changeTicketStatus(true);
    }
}
