package sqa.lab.service.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.service.exception.AddPointFailedException;
import sqa.lab.service.exception.OutOfStockException;
import sqa.lab.service.exception.ShowtimeNotAvailableException;

public interface TicketSellerService {
    public void buyTicket(String movie, LocalDate today, LocalDateTime showtime,String seatId) throws OutOfStockException, ShowtimeNotAvailableException;
    public void buyTicketAndAddPoint(String movie, LocalDate today, LocalDateTime showtime,String seatId,int customerId) throws OutOfStockException, AddPointFailedException, ShowtimeNotAvailableException;
}
