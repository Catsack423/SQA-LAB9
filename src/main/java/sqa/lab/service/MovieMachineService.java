package sqa.lab.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sqa.lab.service.api.TicketSellerService;
import sqa.lab.service.exception.AddPointFailedException;
import sqa.lab.service.exception.OutOfStockException;
import sqa.lab.service.exception.ShowtimeNotAvailableException;

public class MovieMachineService implements TicketSellerService {
    private SeatReservationService seatReservationService;
    private MemberCustomerService memberCustomerService;
    private int ticketStock = 0;

    private final int MIN_STOCK = 0;

    public MovieMachineService(MemberCustomerService memberCustomerService,
            SeatReservationService seatReservationService,
            int ticketStock) {
        this.memberCustomerService = memberCustomerService;
        this.seatReservationService = seatReservationService;
        this.ticketStock = ticketStock;
    }

    public void addTicketStock(int ticket) {
        setTicketStock(ticket);
    }

    public void checkTicketStockAvailable() throws OutOfStockException {

        if (getTicketStock() <= MIN_STOCK) {
            throw new OutOfStockException("Ticket out of Stock");
        }

        return;
    }

    @Override
    public void buyTicket(String movie, LocalDate day, LocalDateTime showtime, String seatId) throws OutOfStockException, ShowtimeNotAvailableException {

        checkTicketStockAvailable();
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

    public int getTicketStock() {
        return ticketStock;
    }

    public void setTicketStock(int ticketStock) {
        this.ticketStock = ticketStock;
    }
}
