//Iris T
//CS 2 Summer 2022-2023
//Array Practice
//Determines whether the first value in an array is repeated again or not
//RayFirst
//6/29/22

public class RayFirst{
	
	/*
	 * tests different cases
	 */
	public static void main(String[] args) {
		RayFirst rt = new RayFirst();
		
		System.out.println( rt.go( new int[]{-99,1,2,3,4,5,6,7,8,9,10,12345} ) );
		System.out.println( rt.go( new int[]{10,9,8,7,6,5,4,3,2,1,-99} ) );
		System.out.println( rt.go( new int[]{10,20,30,40,50,-11818,40,30,20,10} ) );
		System.out.println( rt.go( new int[]{32767} ) );
		System.out.println(rt.go( new int[] {}));
		
	}
	
	/*
	 * determines if the first number gets repeated again
	 * @param array of integers
	 * @return boolean of whether it gets repeated
	 */
	public static boolean go(int[] ray){
		if (ray.length == 0) {
			return false;
		} else {
			int first = ray[0];
			boolean firstRepeats = false;
			for (int i = 1; i < ray.length; i++) {
				if (ray[i] == first) {
					firstRepeats = true;
			}
		}
		return firstRepeats;
	}
}
}