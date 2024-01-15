// Steven G & Iris T
// CS 2 Summer 2022-2023
// Pair Programming Lab
// Runs methods in ArrayListFunHouse
// ArrayListFunHouseRunner
// 7/6/22

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ArrayListFunHouseRunner {

  /*
  * calls upon methods in ArrayListFunHouse
  */
	public static void main( String args[] )
	{
		    System.out.println(ArrayListFunHouse.getListOfFactors(9));
    System.out.println(ArrayListFunHouse.getListOfFactors(23));
    System.out.println(ArrayListFunHouse.getListOfFactors(50));
    System.out.println(ArrayListFunHouse.getListOfFactors(100));
    System.out.println(ArrayListFunHouse.getListOfFactors(762));

    ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(2, 6, 8, 9, 10, 12, 13, 15, 17, 24, 55, 66, 78, 77, 79));
    ArrayListFunHouse.keepOnlyCompositeNumbers(numList);
		
	}
}