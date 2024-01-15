// Steven G & Iris T
// CS 2 Summer 2022-2023
// Pair Programming: Tickets Lab
// Various methods for the Ticket Class
// Ticket
// 7/6/22

public class Ticket {
    private String name;
    private String ticketID;
    private double ticketPrice;
    private boolean sold;

    /*
    * constructor method that sets the instance variables
    * @param n      string for the name
    * @param id     string for the ticket ID
    * @param price  double of the ticket price
    * @param sol    boolean if the ticket is sold
    */
    public Ticket(String n, String id, double price, boolean sol) 
    {
      name = n;
      ticketID = id;
      ticketPrice = price;
      sold = sol;
    }

     /*
    * accessor method for the name
    * @return name
    */
    public String getName()
    {
     return name;
    }

    /*
    * accessor method for the ticket ID
    * @return ticketID
    */
    public String getTicketID()
    {
     return ticketID;
    }

    /*
    * accessor method for the ticket price
    * @return ticketPrice
    */
    public double getPrice()
    {
     return ticketPrice;
    }

    /*
    * accessor method for boolean sold
    * @return sold
    */
    public boolean isSold()
    {
     return sold;
    }

    /*
    * modifier method for the name
    * @param n  string of the name
    */
    public void setName(String n)
    {
     name = n;
    }

    /*
    * modifier method for the price
    * @param p  double of the price
    */
    public void setPrice(double p)
    {
     ticketPrice = p;
    }

    /*
    * modifier method for if the ticket is sold
    * @param sol  boolean for if it's sold
    */
    public void setSold(boolean sol)
    {
     sold = sol;
    }

    /*
    * returns textual representation of the object
    * @return string representation of the ticket
    */
    public String toString()
    {
     return getName() + " " + getTicketID() + " " +
       getPrice() + " " + isSold();
    }
   
}