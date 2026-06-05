package busbooking;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Booking booking = null;

        while (true) {

            String menu = """
                    ===== BUS BOOKING SYSTEM =====
                    1. Create Booking
                    2. Choose Seat
                    3. Confirm Booking
                    4. View Booking
                    5. Cancel Booking
                    6. Exit
                    Enter choice:
                    """;

            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null) break;

            switch (choice) {

                // ---------------- CREATE BOOKING ----------------
                case "1" -> {
                    String id = JOptionPane.showInputDialog("Enter Passenger ID:");
                    String name = JOptionPane.showInputDialog("Enter Name:");
                    String address = JOptionPane.showInputDialog("Enter Address:");
                    String phone = JOptionPane.showInputDialog("Enter Phone Number:");

                    Passenger passenger = new Passenger(id, name, address, phone);

                    String ticketType = JOptionPane.showInputDialog("""
                            Choose Ticket Type:
                            1. Standard Ticket
                            2. Premium Ticket
                            """);

                    String tId = JOptionPane.showInputDialog("Enter Ticket ID:");
                    String dest = JOptionPane.showInputDialog("Enter Destination:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));

                    Ticket ticket;

                    if ("2".equals(ticketType)) {
                        boolean meal = JOptionPane.showConfirmDialog(null, "Meal included?") == 0;
                        ticket = new PremiumTicket(tId, dest, price, "Active", meal);
                    } else {
                        double baggage = Double.parseDouble(JOptionPane.showInputDialog("Enter Baggage Limit:"));
                        ticket = new StandardTicket(tId, dest, price, "Active", baggage);
                    }

                    String bId = JOptionPane.showInputDialog("Enter Booking ID:");
                    booking = new Booking(bId, passenger, ticket);

                    JOptionPane.showMessageDialog(null, "Booking Created Successfully!");
                }

                // ---------------- CHOOSE SEAT ----------------
                case "2" -> {
                    if (booking == null) {
                        JOptionPane.showMessageDialog(null, "Create booking first!");
                        break;
                    }

                    try {
                        int seat = Integer.parseInt(JOptionPane.showInputDialog("Enter Seat Number (1-30):"));
                        booking.chooseSeat(seat);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

                // ---------------- CONFIRM ----------------
                case "3" -> {
                    if (booking == null) {
                        JOptionPane.showMessageDialog(null, "Create booking first!");
                        break;
                    }
                    booking.confirmBooking();
                }

                // ---------------- VIEW ----------------
                case "4" -> {
                    if (booking == null) {
                        JOptionPane.showMessageDialog(null, "No booking found!");
                        break;
                    }
                    booking.displayBooking();
                }

                // ---------------- CANCEL ----------------
                case "5" -> {
                    if (booking == null) {
                        JOptionPane.showMessageDialog(null, "No booking found!");
                        break;
                    }
                    booking.cancelBooking();
                }

                // ---------------- EXIT ----------------
                case "6" -> {
                    JOptionPane.showMessageDialog(null, "Thank you for using the system!");
                    System.exit(0);
                }

                default -> JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }
}