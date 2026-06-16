// TicketNotAvailableException.java
package busbooking.exception;

public class TicketNotAvailableException extends Exception {

    public TicketNotAvailableException() {
        super("No tickets available for the selected route and date. Please try different criteria.");
    }

    public TicketNotAvailableException(String message) {
        super(message);
    }
}
