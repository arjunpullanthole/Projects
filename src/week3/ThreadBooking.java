package week3;

public class ThreadBooking implements Runnable{
    private final TicketBooking tb;
    private final int tickets;

    public ThreadBooking(TicketBooking tb,int tickets) {
        this.tb = tb;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        tb.bookTickets(this.tickets);
    }
}
