package searchNsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class Searching {

	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			String[] lines = Files.readAllLines(new File("src/searchNsort/airports.dat").toPath()).toArray(new String[0]);
			Airport[] airports = new Airport[lines.length];
			for(int i=0; i<lines.length; i++) {
				String line = lines[i].replaceAll("\"", "");
				String[] airportDetails = line.split(",");
				Airport a = new Airport();
				a.setCity(airportDetails[2].trim());
				a.setCountry(airportDetails[3].trim());
				a.setCode3(airportDetails[4].trim());
				airports[i] = a;
			}
			System.out.println(findAirportCodeUsingLinearSearch("LHR", airports));
			System.out.println(findAirportCodeUsingBinarySearch("LHR", airports));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * In the worst case for n airports, n comparision will be required
	 * @param toFind
	 * @param airports
	 * @return
	 */
	public static String findAirportCodeUsingLinearSearch(String toFind, Airport[] airports) {
		for(Airport a: airports) {
			if(toFind.equals(a.getCode3())) {
				return a.getCity();
			}
		}
		return "";
	}
	
	/**
	 * With every iteration the number of elements to traverse is reduced to half
	 * 2 raised to a value 'x' that returns n.  The x is log base 2 n.  Cost if x
	 * 
	 * The Binary search will work on Sorted array 
	 * @param toFind
	 * @param airports
	 * @return
	 */
	public static String findAirportCodeUsingBinarySearch(String toFind, Airport[] airports) {
		int low = 0;
		int high = airports.length - 1;
		while(low<=high) {
			int mid = (low + high) / 2; // if low and high both are big then it can result in overflow
			int safeMid = low + ((high - low)/2);
			Airport a = airports[mid];
			int compare = toFind.compareTo(a.getCode3());
			if(compare<0) { // toFind is lower than mid
				high = mid - 1; // value at mid is already compared with toFind.  
			}else if(compare>0) {  // toFind is higher than mid
				low = mid + 1;
			}else {
				return a.getCity();
			}
		}
		return "";
	}
	
	/**
	 * There can be two ways to implement removing duplicates:
	 * 1. select an item and search for any other occurrance of item in array and remove it.  It is like linear search and cost is high
	 * 2. First sort the array, so that duplicate items are placed next to each other.  Then remove duplicates
	 * @param airports
	 * @return
	 */
	public static Airport[] renoveDuplicates(Airport[] airports) {
		return airports;
	}
	
	static class Airport{
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
	}

}

