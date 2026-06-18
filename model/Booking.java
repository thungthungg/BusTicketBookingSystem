package busbooking.model;

import javax.swing.JOptionPane;
import busbooking.exception.*;

public class Booking {

    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;
    private double totalPrice;
    private boolean confirmed;
    private double discountPercent;
    private double discountAmount;

    public Booking() {}

    public Booking(String bookingId, Passenger passenger, Ticket ticket) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.ticket = ticket;
        this.confirmed = false;
        this.totalPrice = 0;
        this.discountPercent = 0;
        this.discountAmount = 0;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void confirmBooking(String paymentMethod, double discountPercent) {

        if (ticket == null) {
            JOptionPane.showMessageDialog(null, "ERROR: No ticket selected.");
            return;
        }

        if (paymentMethod == null || paymentMethod.equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR: No payment method.");
            return;
        }

        if (passenger == null || passenger.getId() == null || passenger.getId().equals("")) {
            JOptionPane.showMessageDialog(null, "ERROR: Incomplete passenger information.");
            return;
        }

        // Calculate price with discount
        double originalPrice = ticket.getPrice();
        this.discountPercent = discountPercent;

        if (discountPercent > 0) {
            this.totalPrice = ticket.applyDiscount(discountPercent);
    		this.discountAmount = originalPrice - this.totalPrice;
        } else {
            this.discountAmount = 0;
            this.totalPrice = originalPrice;
        }

        confirmed = true;

        String discountMessage = "";
        if (discountPercent > 0) {
            discountMessage = "\nOriginal Price: RM " + originalPrice +
                             "\nDiscount: " + discountPercent + "% (RM " + String.format("%.2f", discountAmount) + ")" +
                             "\nFinal Price: RM " + String.format("%.2f", totalPrice);
        }

        JOptionPane.showMessageDialog(null,
                "✓ BOOKING CONFIRMED!\n" +
                "Booking ID: " + bookingId + "\n" +
                "Passenger ID: " + passenger.getId() + "\n" +
                "Passenger Name: " + passenger.getName() + "\n" +
                "Ticket: " + ticket.getOrigin() + " → " + ticket.getDestination() + "\n" +
                "Date: " + ticket.getTravelDate() + " | Time: " + ticket.getDepartureTime() + "\n" +
                "Payment: " + paymentMethod +
                discountMessage + "\n" +
                "Total: RM " + String.format("%.2f", totalPrice));
    }

    public void confirmBooking(String paymentMethod) {
        // Default: no discount
        confirmBooking(paymentMethod, 0);
    }

    public void confirmBooking() {
        JOptionPane.showMessageDialog(null, "ERROR: Please specify a payment method.");
    }

    public void cancelBooking() throws BookingNotFoundException {
        if (confirmed) {
            confirmed = false;
            JOptionPane.showMessageDialog(null,
                    "✓ BOOKING CANCELLED!\n" +
                    "Booking ID: " + bookingId + "\n" +
                    "Passenger ID: " + passenger.getId() + "\n" +
                    "Passenger Name: " + passenger.getName());
            totalPrice = 0;
            discountPercent = 0;
            discountAmount = 0;
        } else {
            throw new BookingNotFoundException("Booking " + bookingId + " is not confirmed or already cancelled.");
        }
    }

    public void displayBooking() {
        String details = "========== BOOKING DETAILS ==========\n";
        details = details + "Booking ID: " + bookingId + "\n";
        details = details + "Passenger ID: " + passenger.getId() + "\n";
        details = details + "Passenger Name: " + passenger.getName() + "\n";
        details = details + "Total Price: RM " + String.format("%.2f", totalPrice) + "\n";
        if (discountPercent > 0) {
            details = details + "Discount: " + discountPercent + "% (RM " + String.format("%.2f", discountAmount) + ")\n";
        }
        details = details + "Confirmed: ";
        if (confirmed) {
            details = details + "YES";
        } else {
            details = details + "NO";
        }
        details = details + "\n=====================================\n";

        JOptionPane.showMessageDialog(null, details);

        if (passenger != null) {
            passenger.displayInfo();
        }

        if (ticket != null) {
            ticket.displayTicket();
        }
    }
}
