// Iris T
// CS 2 Summer 2022-2023
// CellPhone Assignment
// Calculates the total minutes on the phone, using information from a separate file
// CellPhone
// 6/30/22

import java.util.*;
import java.io.*;

public class CellPhone {
	
	/*
	 * scans CellPhone.dat and calculates the total minutes spent on the phone
	 */
	public static void main(String[] args) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("C:\\Users\\irist\\eclipse-workspace\\CS II\\src\\CellPhone.dat"));
			int numCalls = scan.nextInt();
			int total = 0;
			for (int i = 0; i < 6; i++) {
				String time1 = scan.next();
				String time2 = scan.next();
				String[] timeArr1 = time1.split(":");
				String[] timeArr2 = time2.split(":");
				
				int hour1 = Integer.parseInt(timeArr1[0]);
				int hour2 = Integer.parseInt(timeArr2[0]);
				int min1 = Integer.parseInt(timeArr1[1]);
				int min2 = Integer.parseInt(timeArr2[1]);
				
				total += (hour2 - hour1)*60 + (min2 - min1);
			}
			
			System.out.println("TOTAL MINUTES: " + total);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}
