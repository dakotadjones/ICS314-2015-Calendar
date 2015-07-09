/*This program will create a .ics file that can be used in calendar systems i.e outlook. As of right now it will 
 * it will take in a name, location, description, dates, times for an event from the user. Will expand this functionality further
 * in the future. **NOTE** change file directory before running to create a file in the correct location on 
 * your local system. In command line for user imput but want to change this to a basic UI at some point
 */
package ical;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class iCal {

	private static Scanner sc;

	public static void main(String[] args) {
		String eventName;
		String location;
		String description;
		int startDate;
		int endDate;
		int startTime;
		int endTime;
		
		// Get user input for the event including name, date, time
		
		sc = new Scanner(System.in);
		
		// gets user input for a name 
		System.out.println("Please enter an event name(only letters): ");
		eventName = sc.nextLine();
		
		// gets user input for a location
		System.out.println("Please enter a location: ");
		location = sc.nextLine();
		
		// gets user input for a description
		System.out.println("Please enter a description of the event: ");
		description = sc.nextLine();
		
		// Get user input for a start date
		System.out.println("Please enter a start date in the following format yyyymmdd: " );
		startDate = sc.nextInt();
		
		// Get user input for an end date
		System.out.println("Please enter an end date in the following format yyyymmdd: " );
		endDate = sc.nextInt();
		
	    // Get user input for a start time
		System.out.println("Please enter a start time in 24 hour time in the following format hhmmss: ");
		startTime = sc.nextInt();
		
		// Get user input for an end time
		System.out.println("Please enter an end time in 24 hour time in the following format hhmmss: ");
		endTime = sc.nextInt();
		
		//Create a content string which will be written to the file that uses format needed by ics files
		String content =  "BEGIN:VCALENDAR\r\nVERSION:2.0\r\nMETHOD:PUBLISH\r\nBEGIN:VEVENT\r\nCLASS:PUBLIC\r\n"
				        + "DTEND;TZID=Pacific/Honolulu" + ":" + endDate + "T" + endTime + "\r\nDTSTART;TZID=Pacific/Honolulu"
				        + ":" + startDate + "T" + startTime + "\r\nSUMMARY;LANGUAGE=en-us:" + eventName + "\r\n"
				        + "LOCATION:" + location + "\r\n" + "DESCRIPTION:" + description + "\r\n"
				        + "END:VEVENT\r\nEND:VCALENDAR\r\n";
		
		
		// File operation opens and writes content to the file 		
		try {
			// change file location based on local system
			File file = new File("\\Users\\v778973\\eclipse_workspace\\ical\\src\\ical\\ical_output.ics");
 
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			//write the content string to the file 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Complete, calandar ics file created");
 
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
