package searchNsort;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Please read Searching before coming to this class
public class Sorting {

	public static void main(String[] args) {
		
		// In below small example, the difference in cost is not noticeable. 
		int[] arrayToSort = {7,16,66,43,97,51,100,2,1,200,150,170,30,120};
		System.out.println("Original Array: " + Arrays.toString(arrayToSort));
		
		// Sort using selection sort
		int[] arraySorted = selectionSort(arrayToSort);
		System.out.println("Sorted Array: " + Arrays.toString(arraySorted));
		
		// Sort using Insertion sort
		// Insertion sort is faster as number of loops/iterations are reduced. 
		int[] arrayToSort2 = {7,16,66,43,97,51,100,2,1,200,150,170,30,120};
		arraySorted = insertionSort(arrayToSort2);
		System.out.println("Sorted Array: " + Arrays.toString(arraySorted));
		
		// Using Java built in method
		Random random = new Random();
		List<Integer> numsToSort = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			numsToSort.add(random.nextInt(100));// random gives number between 0 and 100 including
		}
		Collections.sort(numsToSort);
		System.out.println(numsToSort.toString());
		/**
		 * Java built in method is optimized merge sort.  Read more about merge sort here - https://www.geeksforgeeks.org/merge-sort/
		 * 
		 * The sort operation of Collections in Java uses a slightly optimized merge sort algorithm that is fast and stable:
			Fast: It is guaranteed to run in n log(n) time and runs substantially faster on nearly sorted lists. 
					Empirical tests showed it to be as fast as a highly optimized quicksort. 
					A quicksort is generally considered to be faster than a merge sort but isn't stable and doesn't guarantee n log(n) performance.
			Stable: It doesn't reorder equal elements. This is important if you sort the same list repeatedly on different attributes. 
					If a user of a mail program sorts the inbox by mailing date and then sorts it by sender, 
					the user naturally expects that the now-contiguous list of messages from a given sender will (still) be sorted by mailing date. 
					This is guaranteed only if the second sort was stable.
			Source: https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html
		 */
		
		// Sorting objects
		// The inline class Airport here implements the Comprable interface and provides mechanism to compare two Airport objects
		// Lets load the Airports
		try {
			String[] lines = Files.readAllLines(new File("src/searchNsort/airports.dat").toPath()).toArray(new String[0]);
			List<Airport> airports = new ArrayList<Airport>();
			for(int i=0; i<lines.length; i++) {
				String line = lines[i].replaceAll("\"", "");
				String[] airportDetails = line.split(",");
				Airport a = new Airport();
				a.setCity(airportDetails[2].trim());
				a.setCountry(airportDetails[3].trim());
				a.setCode3(airportDetails[4].trim());
				airports.add(a);
			}
			
			// Sort the Airports array
			Collections.sort(airports);
			for(Airport a: airports) {
				System.out.println("Airport code: " + a.getCode3());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * The idea is:
	 * find the smallest element, swap it with element in location 0
	 * find the next smallest element swap it to location 1
	 * and so on
	 * 
	 * The performance is really bad of this algorithm
	 * See https://en.wikipedia.org/wiki/Selection_sort
	 */
	public static int[] selectionSort(int[] intArray) {
		int length = intArray.length;
		for(int i=0; i<length-1; i++) { // the last element not needed here
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
	
	/**
	 * This algo 
	 * first sort the first two elements
	 * then first three
	 * then first four
	 * and so on
	 * 
	 * Since n-1 elements are already sorted fitting the nth element will be faster. 
	 * If arr[n] is greater than arr[n-1] the nothing to do
	 * else compare from greatest (arr[n-1]) to smallest (arr[0) and adjust arr[n]. 
	 * @param intArray
	 * @return
	 */
	public static int[] insertionSort(int[] intArray) {
		int currIndex;
		for(int pos=1; pos<intArray.length; pos++) {
			currIndex = pos;
			while((currIndex > 0) && (intArray[currIndex - 1] > intArray[currIndex])) {
				int temp = intArray[currIndex];
				intArray[currIndex] = intArray[currIndex - 1];
				intArray[currIndex - 1] = temp;
				currIndex = currIndex - 1;
			}
		}
		return intArray;
	}

	public static int[] mergeSort(int[] intArray){
		return intArray;
	}
	static class Airport implements Comparable<Airport>{
		private String city;
		private String country;
		private String code3;
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCode3() {
			return code3;
		}
		public void setCode3(String code3) {
			this.code3 = code3;
		}
		public String toString() {
			return this.city + "," + this.country + "," + this.code3;
		}
		public int compareTo(Airport other) {
			return (this.getCode3().compareTo(other.getCode3()));
		}
	}

}
