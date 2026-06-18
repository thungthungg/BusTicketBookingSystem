package busbooking.model;

import javax.swing.JOptionPane;

public class StandardTicket extends Ticket {

private double baggageLimit;

public StandardTicket() {}

public StandardTicket(String id, String origin, String dest, String date, String time, double price, String status, double baggageLimit) {
super(id, origin, dest, date, time, price, status);
this.baggageLimit = baggageLimit;
}

@Override
public void displayTicket() {
JOptionPane.showMessageDialog(null,
        "STANDARD TICKET\n" +
        "ID: " + getTicketId() + "\n" +
        "Origin: " + getOrigin() + "\n" +
        "Destination: " + getDestination() + "\n" +
        "Travel Date: " + getTravelDate() + "\n" +
        "Departure Time: " + getDepartureTime() + "\n" +
        "Price: RM " + getPrice() + "\n" +
        "Baggage Limit: " + baggageLimit + " kg");
}

public double getBaggageLimit() {
    return baggageLimit;
}

public void setBaggageLimit(double baggageLimit) {
    this.baggageLimit = baggageLimit;
}
}
