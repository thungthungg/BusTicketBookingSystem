package busbooking.model;

import busbooking.sysinterface.Discountable;

public abstract class Ticket implements Discountable {

private String ticketId;
private String destination;
private String origin;
private String travelDate;
private String departureTime;
protected double price;
protected String status;
protected double discount;

public Ticket() {}

public Ticket(String ticketId, String origin, String destination, String travelDate, String departureTime, double price, String status  ) {
this.ticketId = ticketId;
this.destination = destination;
this.price = price;
this.status = status;
this.origin = origin;
this.travelDate = travelDate;
this.departureTime = departureTime;
}

public String getTicketId() { return ticketId; }
public String getDestination() { return destination; }
public String getOrigin() { return origin; }
public double getPrice() { return price; }
public String getStatus() { return status; }
public String getTravelDate() { return travelDate; }
public double getDiscount() { return discount; }

public String getDepartureTime() { return departureTime; }

public void setTicketId(String ticketId) { this.ticketId = ticketId; }
public void setDestination(String destination) { this.destination = destination; }
public void setPrice(double price) { this.price = price; }
public void setStatus(String status) { this.status = status; }
public void setOrigin(String origin) { this.origin = origin; }
public void setTravelDate(String travelDate) { this.travelDate = travelDate; }
public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
public void setDiscount(double discount) { this.discount = discount; }

public double applyDiscount(double percent) {
    return price - (price * percent / 100);
}

public abstract void displayTicket();
}
