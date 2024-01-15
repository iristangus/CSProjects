import java.util.Arrays;

public class BubbleSort {
	
	
	public static void main(String[] args) {
		
		int[] intArray = new int[] {3, 5, 1, 8, 26, 4, 0};
		
		
		boolean swapped;
		for (int i = 0; i < intArray.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < intArray.length - 1; j++) {
				if (intArray[j] > intArray[j+1]) {
					int placeholder = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = placeholder;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(intArray));
	}

}
