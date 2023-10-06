/*import java.util.Scanner;

/*package email_Client;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; 

public class ReadRecipientFile {

	public static String readRecipientFile(String file_name) {
		
		ArrayList<String> clientList = new ArrayList<String>();
	    try {
	      File clientFile = new File(file_name);
	      Scanner fileReader = new Scanner(clientFile);
	      while (fileReader.hasNextLine()) {
	        String data = fileReader.nextLine();
	        String[] clientList1 = data.split(":",2);
	        String[] dataList = clientList1[1].split(",");
	        //System.out.println(clientList1[clientList1.length-1]);
	        System.out.println(dataList[dataList.length-1]);
	        //clientList.add(clientList1[0]); 
	        //System.out.println(data);
	        //return null;
	        
	        // split input and store in list

	        //String[] clientList = data.split(":",2);
	 	   	//String[] dataList = clientList[1].split(",");
	        //System.out.println(dataList.get(dataList.size()-1));
	 	   	//System.out.println(clientList[0]);
	 	   	//System.out.println(dataList[0]);
	      }
	      //System.out.println(clientList.length);
	      //System.out.println(clientList.get(clientList.size()));
	      fileReader.close();
	      
			
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return null;
	    
	}

	ReadRecipientFile.objectCount(clientList);
	public static void objectCount(String[] clientList) {
		System.out.println(clientList.length);
	}
	
	
}

*
*
*
*
public void startEmailClient() {
		System.out.println("Email Client is Running..!!\n"
				+ "Please wait...");
		try {
			final Scanner scanner = new Scanner("sentEmailsList.txt");
			while (scanner.hasNextLine()) {
			   final String lineFromFile = scanner.nextLine();
				if(!(lineFromFile.contains(curentDate))){
					sendGreetingEmail();
				}
			}	
		}catch(NullPointerException e) {
			
		}
		
	}*/