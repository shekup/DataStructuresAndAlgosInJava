package searchNsort;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		int[] arrayToSort = {10,2,3,6,11,4};
		int[] arraySorted = selectionSort(arrayToSort);
		System.out.println(Arrays.toString(arraySorted));
	}
	
	/**
	 * The idea is:
	 * find the smallest element, swap it with element in location 0
	 * find the next smallest element swap it to location 1
	 * and so on
	 */
	public static int[] selectionSort(int[] intArray) {
		int length = intArray.length;
		for(int i=0; i<length; i++) {
			for(int j = i+1; j<length; j++) {
				int elementTosort = intArray[i];
				if(elementTosort > intArray[j]) {
					int temp = intArray[j];
					intArray[j] = elementTosort;
					intArray[i] = temp;
				}
			}
		}
		return intArray;
	}

}
