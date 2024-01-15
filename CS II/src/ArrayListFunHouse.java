// Steven G & Iris T
// CS 2 Summer 2022-2023
// Pair Programming Lab
// Two methods related to factors, using arraylists
// ArrayListFunHouse
// 7/6/22

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ArrayListFunHouse
{

  /*
  * returns an array of factors of a given integer
  * @param number integer to take the factors of
  * @return array of factors
  */
	public static ArrayList<Integer> getListOfFactors(int number)
	{
    ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i < number; i++){
      if (number % i == 0){
        factors.add(i);
      }
    }
    return factors;

	}

  /*
  * removes all prime numbers from an arraylist of integers
  * @param nums arraylist of integers
  * @return arraylist of only composite numbers
  */
	public static void keepOnlyCompositeNumbers( ArrayList<Integer> nums )
	{
		for (int i = nums.size()-1; i >= 0; i--){
      if (getListOfFactors(nums.get(i)).size() == 0){
        nums.remove(i);
      }
    }
    System.out.println(nums);

	}
}