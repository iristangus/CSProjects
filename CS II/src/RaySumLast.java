//Iris T
//CS 2 Summer 2022-2023
//Array Practice
//Gives the sum of all the numbers in an array that are greater than the last value
//RaySumLast
//6/29/22

public class RaySumLast{
	
	/*
	 * Tests different cases
	 */
	public static void main(String[] args) {
		RaySumLast rt = new RaySumLast();
		
		System.out.println( rt.go( new int[]{-99,1,2,3,4,5,6,7,8,9,10,5} ) );
		System.out.println( rt.go( new int[]{10,9,8,7,6,5,4,3,2,1,-99} ) );
		System.out.println( rt.go( new int[]{10,20,30,40,50,-11818,40,30,20,10} ) );
		System.out.println( rt.go( new int[]{32767} ) );
		System.out.println( rt.go( new int[] {}));

	}
	
	/*
	 * Finds the sum of all numbers in the array that are greater than the last value
	 * @param array of integers
	 * @return sum of numbers greater than the last value
	 */
	public static int go(int[] ray){
		if (ray.length == 0) {
			return -1;
		} else {
		
			int sum = 0;
			int last = ray[ray.length-1];
			int numBigger = 0;
			for (int i:ray) {
				if (i > last) {
					sum = sum + i;
					numBigger++;
				}
			}
			if (numBigger == 0) {
				return -1;
			} else {
				return sum;
		}
	}
}
}