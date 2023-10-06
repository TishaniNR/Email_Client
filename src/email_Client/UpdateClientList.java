package email_Client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class UpdateClientList {
	public void updateClientList(String new_recipient_details, String filePath) {
		//System.out.println(new_recipient_details);
		//System.out.println(filePath);
		
		try {
			//Create an object of PrintWriter
			PrintWriter print_writer = new PrintWriter(new FileWriter(filePath, true));
			
			//Write details to text file
			print_writer.write("\n" + new_recipient_details);
			
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
