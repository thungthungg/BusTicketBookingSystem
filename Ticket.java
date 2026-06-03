package busbooking;

public abstract class Ticket implements Discountable {

private String ticketID;
private String destination;
protected double price;
protected String status;
protected double discount;

public Ticket() {}

public Ticket(String ticketID, String destination, double price, String status) {
    this.ticketID = ticketID;
    this.destination = destination;
    this.price = price;
    this.status = status;
}

public String getTicketId() { return ticketID; }
public String getDestination() { return destination; }
public double getPrice() { return price; }
public String getStatus() { return status; }

public void setTicketId(String ticketID) { this.ticketID = ticketID; }
public void setDestination(String destination) { this.destination = destination; }
public void setPrice(double price) { this.price = price; }
public void setStatus(String status) { this.status = status; }

@Override
public double applyDiscount(double percent) {
    discount = price * percent / 100;
    price = price - discount;
    return price;
}

public abstract void displayTicket();
} 
