// Iris T
// CS 3 Summer 2022-2023
// Assignment
// Description
// File Name
// 7/11/22



public class Testing {

	public static void main(String[] args) {

		int[] intArray = new int[] {100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200};
		
		//System.out.println(binarySearchIter(intArray, 70));
		binarySearchIter(intArray, 70);

	}
	public static int binarySearchIter(int[] input, int target) {
		int left = 0;
		int right = input.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2; // (left + right) /2
			//System.out.println("a");
			if (input[mid] == target) { // found!!
				System.out.println("a");
				return mid;
			} else if (input[mid] < target) {
				System.out.println("a");
				left = mid + 1; // moving up
			} else {
				System.out.println("a");
				right = mid - 1; // moving down
			}
		}
		return -1;
	}

}


