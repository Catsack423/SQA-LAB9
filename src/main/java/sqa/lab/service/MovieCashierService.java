package sqa.lab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.repository.SeatRepository;
import sqa.lab.service.api.TicketSellerService;
import sqa.lab.service.exception.AddPointFailedException;
import sqa.lab.service.exception.OutOfStockException;
import sqa.lab.service.exception.ShowtimeNotAvailableException;

public class MovieCashierService implements TicketSellerService {

    private SeatReservationService seatReservationService;
    private MemberCustomerService memberCustomerService;

    MovieCashierService(SeatReservationService seatReservationService,
            MemberCustomerService memberCustomerService) {
        this.memberCustomerService = memberCustomerService;
        this.seatReservationService = seatReservationService;
    }

    @Override
    public void buyTicket(String movie, LocalDate day, LocalDateTime showtime, String seatId) throws OutOfStockException, ShowtimeNotAvailableException {

        int id = seatReservationService.addSeatReservation(movie, showtime, seatId, day);
        System.out.println("Succeed " + id);

    }

    @Override
    public void buyTicketAndAddPoint(String movie, LocalDate today, LocalDateTime showtime, String seatId,
            int customerId) throws OutOfStockException, AddPointFailedException, ShowtimeNotAvailableException {
        buyTicket(movie, today, showtime, seatId);
        try {
            memberCustomerService.addPointToMember(customerId);
        } catch (Throwable e) {
            throw new AddPointFailedException("Cant not add point to Customer");
        }
    }
}
