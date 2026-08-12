package sqa.lab.service.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TicketSellerService {
    public void buyTicket(String movie, LocalDate today, LocalDateTime showtime,String seatId);
}
