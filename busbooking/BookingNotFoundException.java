package busbooking;

public class BookingNotFoundException extends Exception {

    public BookingNotFoundException() {
        super("Booking not found! Please check your Booking ID and Passenger ID.");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}