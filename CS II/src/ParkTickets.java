// Steven G & Iris T
// CS 2 Summer 2022-2023
// Pair Programming: Tickets Lab
// Uses the Ticket Class to make various methods that work with tickets
// ParkTickets
// 7/6/22

import java.util.*;

public class ParkTickets {
  
  /*
  * returns number of tickets sold
  * @param list ArrayList of Tickets
  * @return number of tickets
  */
   public static int numTicketsSold(ArrayList<Ticket> list)
   {
      return list.size();
   }
  
  /*
  * returns total amount of money from selling tickets
  * @param list ArrayList of Tickets
  * @return sum of ticket prices
  */
   public static double totalReceipts(ArrayList<Ticket> list)
   {
      double sum = 0;
     for (Ticket t: list){
       sum += t.getPrice();
     }
     return sum;
   }
  
  /*
  * applies a 20% discount on tickets in the array
  * @param list ArrayList of Tickets
  * @param t    array of Tickets
  */
   public static void applyDiscounts(ArrayList<Ticket> list, Ticket [] t)
   {
    for (Ticket ticket:t){
      double price = ticket.getPrice();
      ticket.setPrice(price * 0.8);
    }
   }
  
  /*
  * returns the name of the person holding the ticket with a matching ticket ID
  * @param list  ArrayList of Tickets
  * @param id    String for ticketID
  * @return name of the person, or null
  */
   public static String ticketHolder(ArrayList<Ticket> list, String id)
   {
      for (Ticket t: list){
        if (t.getTicketID().equals(id)){
          return t.getName();
        }
      }
     return null;
   }
  
  /*
  * returns names of ticket holders
  * @param list ArrayList of Tickets
  * @return string array of names
  */
   public static String [] ticketHolderList(ArrayList<Ticket> list)
   {
       String[] names = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
         names[i] = list.get(i).getName();  
       }
       return names;
   }
  
  /*
  * checks if tickets are distanced by at least 1
  * @param list ArrayList of Tickets
  * @return boolean of whether they're distanced
  */
   public static boolean applySocialDistancing(ArrayList<Ticket> list)
   {
       boolean distanced = true;
     for (int i = 0; i < list.size()-1; i++){
       if (Integer.parseInt(list.get(i).getTicketID()) + 1 == Integer.parseInt(list.get(i+1).getTicketID())){
         distanced = false;
       }
     }
     return distanced;
   }

  /*
  * creates Ticket objects, ArrayList, and calls the methods
  */
    public static void main(String[] args) {
      
        // Create some Ticket objects
      Ticket t1 = new Ticket("Aa", "001", 12.3, true);
      Ticket t2 = new Ticket("Bb", "002", 2.34, true);
      Ticket t3 = new Ticket("Cc", "003", 3.45, true);
        
        
        // Create an arrayList that holds 
      
      ArrayList<Ticket> ticketArrayList = new ArrayList<>(Arrays.asList(t1, t2, t3));        
      Ticket[] ticketArray = new Ticket[]{t2, t3};

      
        //Call the methods in the ParkTickets class
      System.out.println(numTicketsSold(ticketArrayList));
      System.out.println(totalReceipts(ticketArrayList));
      applyDiscounts(ticketArrayList, ticketArray);
      System.out.println(ticketHolder(ticketArrayList, "002"));
      System.out.println(Arrays.toString(ticketHolderList(ticketArrayList)));
      System.out.println(applySocialDistancing(ticketArrayList));
    }
}
