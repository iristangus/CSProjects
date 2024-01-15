//Iris T
//CS 2 Summer 2022-2023
//Array Practice
//Gives the sum of all the numbers in an array
//RayTotal
//6/29/22

public class RayTotal{
	
	/*
	 * Tests the code
	 */
	public static void main(String[] args) {
		RayTotal rt = new RayTotal();
		
		System.out.println( rt.go( new int[]{-99,1,2,3,4,5,6,7,8,9,10,12345} ) );
		System.out.println( rt.go( new int[]{10,9,8,7,6,5,4,3,2,1,-99} ) );
		System.out.println( rt.go( new int[]{10,20,30,40,50,-11818,40,30,20,10} ) );
		System.out.println( rt.go( new int[]{32767} ) );
		System.out.println( rt.go( new int[]{255,255} ) );
		System.out.println( rt.go( new int[]{9,10,-88,100,-555,1000} ) );
		System.out.println( rt.go( new int[]{10,10,10,11,456} ) );
		System.out.println( rt.go( new int[]{-111,1,2,3,9,11,20,30} ) );
		System.out.println( rt.go( new int[]{9,8,7,6,5,4,3,2,0,-2,-989} ) );
		System.out.println( rt.go( new int[]{12,15,18,21,23,1000} ) );
		System.out.println( rt.go( new int[]{250,19,17,15,13,11,10,9,6,3,2,1,-455} ) );	
		System.out.println( rt.go( new int[]{9,10,-8,10000,-5000,1000} ) );											
	}
	
	/*
	 * Finds the sum of all the numbers in an array
	 * @param integer array
	 * @return sum
	 */
	public static int go(int[] ray)	{
		int sum = 0;
		for (int i:ray) {
			sum +=i;
		}
		return sum;
	}
}