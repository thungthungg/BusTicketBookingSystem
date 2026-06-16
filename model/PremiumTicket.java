package busbooking.model;

import javax.swing.JOptionPane;
import busbooking.sysinterface.Discountable;

public class PremiumTicket extends Ticket {

   private boolean mealIncluded;

   public PremiumTicket() {}

   public PremiumTicket(String id, String origin, String dest, String date, String time, double price, String status, boolean mealIncluded) {
       super(id, origin, dest, date, time, price, status);
       this.mealIncluded = mealIncluded;
   }

   @Override
   public void displayTicket() {
       JOptionPane.showMessageDialog(null,
               "PREMIUM TICKET\n" +
               "ID: " + getTicketId() + "\n" +
               "Origin: " + getOrigin() + "\n" +
               "Destination: " + getDestination() + "\n" +
               "Travel Date: " + getTravelDate() + "\n" +
               "Departure Time: " + getDepartureTime() + "\n" +
               "Price: RM " + getPrice() + "\n" +
               "Meal: " + (mealIncluded ? "Yes" : "No"));
   }

   public boolean isMealIncluded() {
       return mealIncluded;
   }

   public void setMealIncluded(boolean mealIncluded) {
       this.mealIncluded = mealIncluded;
   }
}
