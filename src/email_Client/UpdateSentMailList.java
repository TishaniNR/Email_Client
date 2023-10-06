package email_Client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class  UpdateSentMailList {
	
	public static void  updateSentMail(String subject, String emailAddress, String name,String date, String filePath) {
		
		try {
			//Create an object of PrintWriter
			PrintWriter print_writer = new PrintWriter(new FileWriter(filePath, true));
			
			//Write details to text file
			print_writer.write("\n" + subject + "," + emailAddress + "," + name + "," + date);
			
			//Close PrintWriter Object
			print_writer.close();
		}
		
		// Catch if exceptions occurs
        catch (IOException e) {
 
            // Print the exception
            // using getMessage() method
            System.out.print(e.getMessage());
        }
		
	}

}