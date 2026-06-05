package busbooking;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Booking {

    private static ArrayList<Integer> bookedSeats = new ArrayList<>();

    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;
    private int seatNo;
    private double totalPrice;
    private boolean confirmed;

    public Booking() {}

    public Booking(String bookingId, Passenger passenger, Ticket ticket) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.ticket = ticket;
    }

    public void chooseSeat(int seat) throws Exception {
        //seat means seat number
        if (confirmed) {
            throw new Exception("Cannot change seat after booking is confirmed!");
        }

        if (seat <= 0 || seat > 30) {
            throw new Exception("Invalid seat number (1-30 only)");
        }

        if (bookedSeats.contains(seat)) {
            throw new Exception("Seat already taken!");
        }

        if (this.seatNo != 0) {
            throw new Exception("You already selected seat " + seatNo + ". Cancel first to change seat.");
        }

        this.seatNo = seat;
        bookedSeats.add(seat);

        JOptionPane.showMessageDialog(null,"Seat " + seat + " successfully booked!");
    }
    
    public void confirmBooking() {

        if (seatNo == 0) {
            JOptionPane.showMessageDialog(null, "Please select a seat first!");
            return;
        }

        if (confirmed) {
            JOptionPane.showMessageDialog(null, "Booking already confirmed!");
            return;
        }

        totalPrice = ticket.getPrice();
        confirmed = true;

        JOptionPane.showMessageDialog(null,"Booking Confirmed!\nTotal Price: RM " + totalPrice);
    }

    public void cancelBooking() {
        
        if (seatNo == 0) {
            JOptionPane.showMessageDialog(null, "No seat to be cancelled!");
            return;
        }

        confirmed = false;
        bookedSeats.remove(Integer.valueOf(seatNo));

        JOptionPane.showMessageDialog(null,"Booking Cancelled. Seat released.");
    }

    public void displayBooking() {

        String status = confirmed ? "CONFIRMED" : "PENDING";
        String priceDisplay = confirmed ? ("RM " + totalPrice) : "Not calculated yet";
        String seatDisplay = (seatNo == 0) ? "Not selected" : String.valueOf(seatNo);
    
        JOptionPane.showMessageDialog(null,
        "BOOKING DETAILS (" + status + ")\n" +
        "Booking ID: " + bookingId + "\n" +
        "Seat No: " + seatDisplay + "\n" +
        "Total Price: " + priceDisplay);
    
        passenger.displayInfo();
        ticket.displayTicket();
    }
}

