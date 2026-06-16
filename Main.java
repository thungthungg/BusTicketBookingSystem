package busbooking;

import busbooking.exception.*;
import busbooking.sysinterface.*;
import busbooking.model.*;
import javax.swing.*;
import java.util.*;

public class Main {

    private static ArrayList<Booking> allBookings = new ArrayList<>();
    private static int bookingCounter = 1000;
    private static ArrayList<Ticket> availableTickets = new ArrayList<>();

    public static void main(String[] args) {

        initializeTickets();

        while (true) {
            String menu = """
                    ===== BUS BOOKING SYSTEM =====

                    1. Book a Ticket
                    2. Cancel Booking
                    3. View All Bookings
                    4. View Available Routes
                    5. Exit

                    Enter your choice:
                    """;

            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null || choice.equals("5")) {
                JOptionPane.showMessageDialog(null, "Thank you for using the Bus Booking System!");
                System.exit(0);
            }

            switch (choice) {
                case "1" -> bookTicket();
                case "2" -> cancelBooking();
                case "3" -> viewAllBookings();
                case "4" -> viewAvailableRoutes();
                default -> JOptionPane.showMessageDialog(null, "Invalid choice! Please enter 1-5");
            }
        }
    }

    private static void initializeTickets() {
        availableTickets.add(new StandardTicket("T001", "Kuala Lumpur", "Penang", "2026-06-15", "08:00", 45.0, "Available", 20.0));
        availableTickets.add(new StandardTicket("T002", "Kuala Lumpur", "Penang", "2026-06-15", "14:00", 45.0, "Available", 20.0));
        availableTickets.add(new StandardTicket("T003", "Kuala Lumpur", "Johor Bahru", "2026-06-16", "09:00", 55.0, "Available", 25.0));
        availableTickets.add(new StandardTicket("T004", "Penang", "Kuala Lumpur", "2026-06-17", "10:00", 45.0, "Available", 20.0));
        availableTickets.add(new StandardTicket("T005", "Johor Bahru", "Kuala Lumpur", "2026-06-18", "15:00", 55.0, "Available", 25.0));
        availableTickets.add(new PremiumTicket("P001", "Kuala Lumpur", "Penang", "2026-06-15", "09:00", 85.0, "Available", true));
        availableTickets.add(new PremiumTicket("P002", "Kuala Lumpur", "Penang", "2026-06-15", "15:00", 85.0, "Available", true));
        availableTickets.add(new PremiumTicket("P003", "Kuala Lumpur", "Johor Bahru", "2026-06-16", "10:00", 95.0, "Available", false));
        availableTickets.add(new PremiumTicket("P004", "Penang", "Kuala Lumpur", "2026-06-17", "11:00", 85.0, "Available", true));
    }

    private static void bookTicket() {
        try {
            JOptionPane.showMessageDialog(null, "=== NEW BOOKING ===\nPlease enter passenger details:");

            String passengerId = "";
            while (true) {
                passengerId = JOptionPane.showInputDialog("Enter Passenger ID (or click Cancel to exit):");
                if (passengerId == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }
                if (!passengerId.equals("")) {
                    break;
                }
                JOptionPane.showMessageDialog(null, "Passenger ID cannot be empty! Please enter again.");
            }

            String name = "";
            while (true) {
                name = JOptionPane.showInputDialog("Enter Passenger Name (or click Cancel to exit):");
                if (name == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }
                if (!name.equals("")) {
                    break;
                }
                JOptionPane.showMessageDialog(null, "Passenger Name cannot be empty! Please enter again.");
            }

       		String address = "";
            while (true) {
                address = JOptionPane.showInputDialog("Enter Address (or click Cancel to exit):");
				if (address == null) {
					JOptionPane.showMessageDialog(null, "Booking cancelled.");
					return;
				}
                if (!address.equals("")) {
                    break;
                }
                JOptionPane.showMessageDialog(null, "Address cannot be empty! Please enter again.");
            }

            String phone = "";
            while (true) {
                phone = JOptionPane.showInputDialog("Enter Phone Number (or click Cancel to exit):");
                if (phone == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }
                if (!phone.equals("")) {
                    break;
                }
                JOptionPane.showMessageDialog(null, "Phone Number cannot be empty! Please enter again.");
            }

            Passenger passenger = new Passenger(passengerId, name, address, phone);

            JOptionPane.showMessageDialog(null, "=== TRAVEL REQUIREMENTS ===");

            String origin = "";

            while (true) {

                String routeMsg = "===== AVAILABLE ROUTES =====\n\n";

                ArrayList<String> shownRoutes = new ArrayList<>();

                for (Ticket t : availableTickets) {

                    String route = t.getOrigin() + " → " + t.getDestination();

                    if (!shownRoutes.contains(route)) {
                        shownRoutes.add(route);
                        routeMsg += shownRoutes.size() + ". " + route + "\n";
                    }
                }

                routeMsg += "\n============================\n";
                routeMsg += "Enter Origin City (or click Cancel to exit):";

                origin = JOptionPane.showInputDialog(routeMsg);

                if (origin == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }

                if (!origin.trim().isEmpty()) {
                    break;
                }

                JOptionPane.showMessageDialog(
                    null,
                    "Origin City cannot be empty! Please enter again."
                );
            }

            String destination = "";

            while (true) {

                String destPreview = "===== AVAILABLE DESTINATIONS =====\n\n";

                ArrayList<String> shownDest = new ArrayList<>();

                for (Ticket t : availableTickets) {

                    if (t.getOrigin().equalsIgnoreCase(origin)) {

                    String dest = t.getDestination();

                    if (!shownDest.contains(dest)) {
                        shownDest.add(dest);
                        destPreview += shownDest.size() + ". " + dest + "\n"; }
                    }
                }

                if (shownDest.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "No destinations found for origin: " + origin);
                    return;
                }

                destPreview += "\n============================\n";
                destPreview += "Enter Destination City (or click Cancel to exit):";

                destination = JOptionPane.showInputDialog(destPreview);

                if (destination == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }

                if (!destination.trim().isEmpty()) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                "Destination cannot be empty! Please enter again.");
            }

            String date = "";

            while (true) {

                String datePreview = "===== AVAILABLE DATES =====\n\n";

                ArrayList<String> shownDates = new ArrayList<>();

                for (Ticket t : availableTickets) {

                    if (t.getOrigin().equalsIgnoreCase(origin) && t.getDestination().equalsIgnoreCase(destination)) {

                    String d = t.getTravelDate();

                    if (!shownDates.contains(d)) {
                        shownDates.add(d);
                        datePreview += shownDates.size() + ". " + d + "\n"; }
                    }
                }

                if (shownDates.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                 "No travel dates found for this route.");
                        return;
                }

                datePreview += "\n============================\n";
                datePreview += "Enter Travel Date (YYYY-MM-DD):";

                date = JOptionPane.showInputDialog(datePreview);

                if (date == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }

                if (!date.trim().isEmpty()) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                "Travel Date cannot be empty! Please enter again.");
            }

            ArrayList<Ticket> matchingTickets = new ArrayList<>();
            for (Ticket ticket : availableTickets) {
                if (ticket.getOrigin().equalsIgnoreCase(origin) &&
                    ticket.getDestination().equalsIgnoreCase(destination) &&
                    ticket.getTravelDate().equals(date)) {
                    matchingTickets.add(ticket);
                }
            }

            if (matchingTickets.isEmpty()) {
                throw new TicketNotAvailableException();
            }

            String displayMsg = "=== AVAILABLE TICKETS ===\n\n";
            for (int i = 0; i < matchingTickets.size(); i++) {
                Ticket t = matchingTickets.get(i);
                displayMsg = displayMsg + (i + 1) + ". ";
                if (t instanceof PremiumTicket) {
                    displayMsg = displayMsg + "[PREMIUM] ";
                } else {
                    displayMsg = displayMsg + "[STANDARD] ";
                }
                displayMsg = displayMsg + "Time: " + t.getDepartureTime();
                displayMsg = displayMsg + " | Price: RM " + t.getPrice();
                if (t instanceof StandardTicket) {
                    displayMsg = displayMsg + " | Baggage: " + ((StandardTicket)t).getBaggageLimit() + "kg";
                } else if (t instanceof PremiumTicket) {
                    displayMsg = displayMsg + " | Meal: " + (((PremiumTicket)t).isMealIncluded() ? "Yes" : "No");
                }
                displayMsg = displayMsg + "\n";
            }

            int choice = 0;
            while (true) {
                String choiceStr = JOptionPane.showInputDialog(displayMsg + "\nSelect ticket number (1-" + matchingTickets.size() + ") (or click Cancel to exit):");
                if (choiceStr == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }
                try {
                    choice = Integer.parseInt(choiceStr);
                    if (choice >= 1 && choice <= matchingTickets.size()) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid selection! Please choose a number between 1 and " + matchingTickets.size());
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                }
            }

            Ticket selectedTicket = matchingTickets.get(choice - 1);

            // Ask for discount with validation
            double discountPercent = 0;
            String discountType = "";
            while (true) {
                String discountChoice = JOptionPane.showInputDialog("""
                    Select Discount Type (or click Cancel to exit):
                    1. No discount
                    2. Student discount (10%)
                    3. Senior citizen discount (15%)
                    4. Early bird discount (20%)
                    """);

                if (discountChoice == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }

                if (discountChoice.equals("1")) {
                    discountPercent = 0;
                    discountType = "No discount";
                    break;
                } else if (discountChoice.equals("2")) {
                    discountPercent = 10;
                    discountType = "Student discount (10%)";
                    break;
                } else if (discountChoice.equals("3")) {
                    discountPercent = 15;
                    discountType = "Senior citizen discount (15%)";
                    break;
                } else if (discountChoice.equals("4")) {
                    discountPercent = 20;
                    discountType = "Early bird discount (20%)";
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select 1, 2, 3, or 4.");
                }
            }

            String bookingId = "BKG" + bookingCounter;
            bookingCounter = bookingCounter + 1;
            Booking booking = new Booking(bookingId, passenger, selectedTicket);

            // Payment method with validation
            String paymentMethod = "";
            while (true) {
                String payment = JOptionPane.showInputDialog("""
                    Select Payment Method (or click Cancel to exit):
                    1. Cash
                    2. Credit Card
                    3. Online Banking
                    4. E-Wallet
                    """);

                if (payment == null) {
                    JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    return;
                }

                if (payment.equals("1")) {
                    paymentMethod = "Cash";
                    break;
                } else if (payment.equals("2")) {
                    paymentMethod = "Credit Card";
                    break;
                } else if (payment.equals("3")) {
                    paymentMethod = "Online Banking";
                    break;
                } else if (payment.equals("4")) {
                    paymentMethod = "E-Wallet";
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid payment method! Please select 1, 2, 3, or 4.");
                }
            }

			if (discountPercent == 0)
				booking.confirmBooking(paymentMethod);
            // Confirm booking with discount
            else
            	booking.confirmBooking(paymentMethod, discountPercent);

            if (booking.isConfirmed()) {
                allBookings.add(booking);
                JOptionPane.showMessageDialog(null,
                    "✓ BOOKING SUCCESSFUL!\n\n" +
                    "Booking Details:\n" +
                    "----------------------\n" +
                    "Booking ID: " + bookingId + "\n" +
                    "Passenger ID: " + passengerId + "\n" +
                    "Discount: " + discountType + "\n\n" +
                    "IMPORTANT:\n" +
                    "Please save your Booking ID and Passenger ID.\n" +
                    "They are required for cancellation." );
            }

        } catch (TicketNotAvailableException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void cancelBooking() {
        if (allBookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings found in the system.");
            return;
        }

        String passengerId = "";
        while (true) {
            passengerId = JOptionPane.showInputDialog("Enter Passenger ID to cancel booking (or click Cancel to exit):");
            if (passengerId == null) {
                return;
            }
            if (!passengerId.equals("")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Passenger ID cannot be empty! Please enter again.");
        }

        String bookingId = "";
        while (true) {
            bookingId = JOptionPane.showInputDialog("Enter Booking ID to cancel (or click Cancel to exit):");
            if (bookingId == null) {
                return;
            }
            if (!bookingId.equals("")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Booking ID cannot be empty! Please enter again.");
        }

        Booking bookingToCancel = null;
        for (int i = 0; i < allBookings.size(); i++) {
            Booking b = allBookings.get(i);
            if (b.getBookingId().equals(bookingId) && b.getPassenger().getId().equals(passengerId)) {
                bookingToCancel = b;
                break;
            }
        }

        if (bookingToCancel == null) {
            JOptionPane.showMessageDialog(null, "Booking not found! Please check your Booking ID and Passenger ID.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to cancel this booking?\n" +
            "Booking ID: " + bookingId + "\n" +
            "Passenger ID: " + passengerId + "\n" +
            "Passenger Name: " + bookingToCancel.getPassenger().getName() + "\n" +
            "Destination: " + bookingToCancel.getTicket().getOrigin() + " → " +
            bookingToCancel.getTicket().getDestination() + "\n" +
            "Date: " + bookingToCancel.getTicket().getTravelDate() + "\n" +
            "Time: " + bookingToCancel.getTicket().getDepartureTime(),
            "Confirm Cancellation",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                bookingToCancel.cancelBooking();
                allBookings.remove(bookingToCancel);
            } catch (BookingNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    private static void viewAllBookings() {
        if (allBookings.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings found in the system.");
            return;
        }

        String allInfo = "========== ALL BOOKINGS ==========\n";
        allInfo = allInfo + "Total Bookings: " + allBookings.size() + "\n";
        allInfo = allInfo + "===================================\n\n";

        for (int i = 0; i < allBookings.size(); i++) {
            Booking b = allBookings.get(i);
            allInfo = allInfo + "Booking #" + (i + 1) + "\n";
            allInfo = allInfo + "─────────────────────────────────\n";
            allInfo = allInfo + "Booking ID: " + b.getBookingId() + "\n";
            allInfo = allInfo + "Passenger ID: " + b.getPassenger().getId() + "\n";
            allInfo = allInfo + "Passenger Name: " + b.getPassenger().getName() + "\n";
            allInfo = allInfo + "From: " + b.getTicket().getOrigin() + " → " + b.getTicket().getDestination() + "\n";
            allInfo = allInfo + "Date: " + b.getTicket().getTravelDate() + "\n";
            allInfo = allInfo + "Time: " + b.getTicket().getDepartureTime() + "\n";
            if (b.getDiscountPercent() > 0) {
                allInfo = allInfo + "Discount: " + b.getDiscountPercent() + "% (RM " + String.format("%.2f", b.getDiscountAmount()) + ")\n";
            }
            allInfo = allInfo + "Total Price: RM " + String.format("%.2f", b.getTotalPrice()) + "\n";
            allInfo = allInfo + "Status: ";
            if (b.isConfirmed()) {
                allInfo = allInfo + "CONFIRMED";
            }
            allInfo = allInfo + "\n\n";
        }

        JOptionPane.showMessageDialog(null, allInfo);
    }

	private static void viewAvailableRoutes() {
	    if (availableTickets.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No available tickets in the system.");
	        return;
	    }

	    // Store unique route combinations
	    ArrayList<String> uniqueRoutes = new ArrayList<>();
	    ArrayList<ArrayList<Ticket>> routeTickets = new ArrayList<>();

	    // Group tickets by route
	    for (Ticket ticket : availableTickets) {
	        String route = ticket.getOrigin() + " → " + ticket.getDestination();

	        // Check if route already exists
	        int routeIndex = -1;
	        for (int i = 0; i < uniqueRoutes.size(); i++) {
	            if (uniqueRoutes.get(i).equals(route)) {
	                routeIndex = i;
	                break;
	            }
	        }

	        // If new route, add it
	        if (routeIndex == -1) {
	            uniqueRoutes.add(route);
	            ArrayList<Ticket> newRouteList = new ArrayList<>();
	            newRouteList.add(ticket);
	            routeTickets.add(newRouteList);
	        } else {
	            // Add ticket to existing route
	            routeTickets.get(routeIndex).add(ticket);
	        }
	    }

	    // Build display message
	    String displayMsg = "========== AVAILABLE ROUTES ==========\n\n";

	    for (int i = 0; i < uniqueRoutes.size(); i++) {
	        String route = uniqueRoutes.get(i);
	        ArrayList<Ticket> tickets = routeTickets.get(i);

	        displayMsg = displayMsg + "【" + (i + 1) + "】 " + route + "\n";
	        displayMsg = displayMsg + "     Available trips: " + tickets.size() + "\n";

	        // Show time options for this route
	        for (int j = 0; j < tickets.size(); j++) {
	            Ticket t = tickets.get(j);
	            displayMsg = displayMsg + "       - " + t.getDepartureTime();
	            if (t instanceof PremiumTicket) {
	                displayMsg = displayMsg + " [PREMIUM]";
	            } else {
	                displayMsg = displayMsg + " [STANDARD]";
	            }
	            displayMsg = displayMsg + " (RM " + t.getPrice() + ")\n";
	        }
	        displayMsg = displayMsg + "\n";
	    }

	    displayMsg = displayMsg + "=====================================\n";
	    displayMsg = displayMsg + "Total Routes: " + uniqueRoutes.size();

	    JOptionPane.showMessageDialog(null, displayMsg);
	}
}
