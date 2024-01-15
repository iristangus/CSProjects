// Saahil G & Iris T
// CS Summer 2022-2023 
// Pair Programming: Temperature
// using methods and arrays to solve exercises
// Temperature
// 06/29/2022

import java.util.*;
import java.lang.*;

class Temperature {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int [] temps = new int [7];
    String [] daysOfWeek = new String [7];
    daysOfWeek[0] = "Monday";
    daysOfWeek[1] = "Tuesday";
    daysOfWeek[2] = "Wednesday";
    daysOfWeek[3] = "Thursday";
    daysOfWeek[4] = "Friday";
    daysOfWeek[5] = "Saturday";
    daysOfWeek[6] = "Sunday";
    
    System.out.println("Enter 7-day temps: ");
    for (int i = 0; i < 7; i++){
      System.out.print(daysOfWeek[i] + ": ");
      temps[i] = scan.nextInt();
    }
    scan.close();

    System.out.println(average(temps));
    System.out.println(evenTemps(temps));
    System.out.println(highestTemp(temps, daysOfWeek));
    System.out.println(higherThan70(temps));
    System.out.println(highestChange(temps));
    System.out.println(celsius(temps));
    System.out.println(shift(temps));
    
  }

  /*
   * calculates average of all elements in array
   * @params: int array
   * @return: double
   */
  public static double average(int[] ray){
    double sum = 0;
    for (int i : ray){
      sum += i;
    }
    sum /= (double) ray.length;
    sum = Math.round(sum*1000)/1000.0;
    return sum;
  }

  /*
  * calculates the number of even temperatures this week
  * @params: int array
  * @return: int
  */
  public static int evenTemps(int[] ray){
    int numEvenTemps = 0;
    for (int i:ray){
      if (i%2 == 0){
        numEvenTemps++;
      }
    }
    return numEvenTemps;
  }

  /*
   * finds the highest temperature that week and
   * returns the exact value and day
   * @params: int array
   * @return: String
   */
  public static String highestTemp(int[] ray, String[] daysOfWeek){
    int highest = ray[0]-1;
    int dayNum = 0;
    String day = "";
    for (int i = 0; i < ray.length; i++){
      if (ray[i] > highest){
        highest = ray[i];
        dayNum = i;
      }
    }
    day += daysOfWeek[dayNum] + ": " + highest;
    return day;
  }

  /*
  * calculates the number of days where the     temperature is higher than 70
  * @params: int array
  * @return: int
  */
  public static int higherThan70(int[] ray){
    int numDays =  0;
    for (int i: ray){
      if (i >= 70){
        numDays++;
      }
    }
    return numDays;
  }

  /*
   * returns the highest change between two days
   * @params: int array
   * @return: int
   */
  public static int highestChange(int[] ray){
    int change = 0;
    for (int i = 0; i < ray.length-1; i++){
      if (Math.abs(ray[i]-ray[i+1]) > change){
        change = Math.abs(ray[i]-ray[i+1]);
      }
    }
    return change;
  }

  /*
  * returns the string representation of an int array of the temperatures converted to celsius
  * @params: int array
  * @return: string representation of an int array
  */
  public static String celsius(int[] ray){
    int[] celsiusTemp = new int[7];
    for (int i = 0; i < 7; i++){
      celsiusTemp[i] = (ray[i]-30)/2;
    }
    return Arrays.toString(celsiusTemp);
  }

  /*
   * shifts all elements in array to the right
   * @params: int array
   * @return: String representation of array
  */
  public static String shift(int [] ray){
    int last = ray[ray.length-1];
    for (int i = ray.length-1; i > 0; i--){
      ray[i] = ray[i-1];
    }
    ray[0] = last;
  return Arrays.toString(ray);
  }
}