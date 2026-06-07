package busbooking;

public class StandardTicket extends Ticket {

    public StandardTicket() {}

    public StandardTicket(String ticketID, String origin,
                          String destination, String date,
                          String time, double price,
                          String status) {

        super(ticketID, origin, destination, date, time, price, status);
    }

    public String getTicketType() {
        return "Standard";
    }

    @Override
    public void displayTicket() {

        System.out.println("===== STANDARD TICKET =====");
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Origin: " + getOrigin());
        System.out.println("Destination: " + getDestination());
        System.out.println("Date: " + getDate());
        System.out.println("Time: " + getTime());
        System.out.println("Price: RM " + getPrice());
        System.out.println("Status: " + getStatus());
        System.out.println("Type: " + getTicketType());
    }
}