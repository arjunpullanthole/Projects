package week3;

public class TicketBooking {
    private int tickets;

    public TicketBooking(int tickets) {
        this.tickets = tickets;
    }

    public int getAvailableTickets()
    {
        return this.tickets;
    }

    public synchronized void bookTickets(int tickets)
    {
        if (this.tickets < tickets)
            System.out.println("Tickets not available");
        else
        {
            this.tickets -= tickets;
            try
            {
                Thread.sleep(100);      //Processing Time
                System.out.printf("Thread %d booked %d tickets\n",Thread.currentThread().threadId(),tickets);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
