public class EnumPractice
{
   //Day is a data type which is very simple - it must be one of 7 particular things.
   //The best way to represent this in Java is through an enum, instead of making
   //a whole new class for it. An enum looks like this:
   public enum Day
   {
      SUNDAY,
      MONDAY,
      TUESDAY,
      WEDNESDAY,
      THURSDAY,
      FRIDAY,
      SATURDAY
   }
   
   public static void main(String[] args)
   {
      //We can access an enum like this
      Day myDay = Day.SATURDAY;
      
      //We can compare enums like this
      if (myDay == Day.SATURDAY) //Actually, == and .equals() both work for enums!
      {
         System.out.println("Saturday is Saturday!");
      }
      
      //We can use them as parameters and return values:
      Day returnedDay = returnMonday(Day.FRIDAY);
      System.out.println("Return value was " + returnedDay);
      
      //One interesting thing you can do is get an array of all possible values
      Day[] allDays = Day.values();
      //Then you could loop through it and print out all the days
      System.out.print("All the days: ");
      for (int i = 0; i < allDays.length; i++)
      {
         System.out.print(allDays[i] + " ");
      }
      System.out.println();
      
      //Want to practice this? Optional tasks below.
      //TASK: Call your printGreeting() method (defined below) and pass Sunday as the parameter
      //TASK: Call your printGreeting() method (defined below) and pass Tuesday as the parameter
   }
   
   public static Day returnMonday(Day d)
   {
      System.out.println("Parameter was " + d);
      return Day.MONDAY;
   }
   
   //TASK: Create a method called printGreeting(). It should have 
   //      one parameter of data type Day, and no return value.
   //      If the parameter is Saturday or Sunday, it should print
   //      "Happy weekend!". Otherwise, it should print "Happy weekday!"
   
}