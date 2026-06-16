package busbooking.model;

import javax.swing.JOptionPane;
import busbooking.sysinterface.Discountable;

public class Passenger {
   private String id;
   private String name;
   private String address;
   private String phoneNumber;

   public Passenger() {}

   public Passenger(String id, String name, String address, String phoneNumber) {
       this.id = id;
       this.name = name;
       this.address = address;
       this.phoneNumber = phoneNumber;
   }

   public String getId() { return id; }
   public String getName() { return name; }
   public String getAddress() { return address; }
   public String getPhoneNumber() { return phoneNumber; }

   public void setId(String id) { this.id = id; }
   public void setName(String name) { this.name = name; }
   public void setAddress(String address) { this.address = address; }
   public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

   public void displayInfo() {
       JOptionPane.showMessageDialog(null,
               "Passenger Info\n" +
               "ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "Phone: " + phoneNumber);
   }
}
