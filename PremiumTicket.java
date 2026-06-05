package busbooking;

public class PremiumTicket extends Ticket {

    private String meal;

    public PremiumTicket() {}

    public PremiumTicket(String ticketID, String origin,
                         String destination, String date,
                         String time, double price,
                         String status, String meal) {

        super(ticketID, origin, destination, date, time, price, status);

        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getTicketType() {
        return "Premium";
    }

    @Override
    public void displayTicket() {

        System.out.println("===== PREMIUM TICKET =====");
        System.out.println("Ticket ID: " + getTicketId());
        System.out.println("Origin: " + getOrigin());
        System.out.println("Destination: " + getDestination());
        System.out.println("Date: " + getDate());
        System.out.println("Time: " + getTime());
        System.out.println("Price: RM " + getPrice());
        System.out.println("Status: " + getStatus());
        System.out.println("Meal: " + meal);
        System.out.println("Type: " + getTicketType());
    }
}