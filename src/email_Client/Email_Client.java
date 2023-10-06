package email_Client;

//index number - 200530D

//import libraries
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Email_Client {

   public static void main(String[] args) {
	   
	   	
	   	RequireEmailClient requireEmailClientObj = new RequireEmailClient();
	   	requireEmailClientObj.readClientFile("clientList.txt");
	   	
	   	// call method to send birthday greeting on the correct day for recipient who has birthday on current day
	   	requireEmailClientObj.startEmailClient();
	   	
	   	String sentMailPath = "D:\\UoM\\CSE\\Semester02\\CS1040 Program Construction\\Email_Client_Assignment\\sentEmailsList.txt";
	   	String clientPath= "D:\\UoM\\CSE\\Semester 02\\CS1040 Program Construction\\Email_Client_Assignment\\clientList1.txt";
	   	
	   	
         try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter option type: \n"
			       + "1 - Adding a new recipient\n"
			       + "2 - Sending an email\n"
			       + "3 - Printing out all the recipients who have birthdays\n"
			       + "4 - Printing out details of all the emails sent\n"
			       + "5 - Printing out the number of recipient objects in the application");

			 int option = scanner.nextInt();
			 
			 switch(option){
			       case 1:
			           // input format - Official: nimal,nimal@gmail.com,ceo
			           // Use a single input to get all the details of a recipient
			           // code to add a new recipient
			           // store details in clientList.txt file
			           // Hint: use methods for reading and writing files
			    	   System.out.println("Input Format :\n"
			     			  + "Official:<name>,<email>,<designation>\n"
			     			  + "Office_friend:<name>,<email>,<designation>,<birthday>\n"
			     			  + "Personal:<name>,<nickname>,<email>,<birthday>\n"
			     			  + "Example inputs:   	Official: nimal,nimal@gmail.com,ceo\n"
			     			  + "            		Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12\n"
			     			  + "            		Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10\n\n"
			     			  + "Enter details of the new recipient ....: ");
			    	   
			    	   UpdateClientList new_recipient = new UpdateClientList();
			    	   Scanner input1 = new Scanner(System.in);
			    	   String new_recipient_details = input1.nextLine();
			    	   new_recipient.updateClientList(new_recipient_details, clientPath );
			    	   
			           break;
			       case 2:
			           // input format - email, subject, content
			           // code to send an email
			    	   System.out.println("Input Format :  "
			      			  + "<email>,<subject>,<content>\n"
			    			  + "Enter Email details....:\n");
			    	   Scanner input2 = new Scanner(System.in);
			    	   String email_details = input2.nextLine();
			    	   
			    	   // split input and store in list
			    	   List<String> emailDataList = Arrays.asList(email_details.split(","));
			    	   
			    	   System.out.println("Email is sending...Please Wait...");
			    	   //call sendMail method in SendMail class
			    	   SendMail.sendMail(emailDataList.get(0),emailDataList.get(1),emailDataList.get(2));
			    	   System.out.println("Email sent\n");
			    	   
			    	   //save sent mail details to text file
			    	   SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
			    	   String curentDate = formatDate.format(new Date());
			    	   UpdateSentMailList.updateSentMail(emailDataList.get(1), emailDataList.get(0), "No name entered", curentDate, sentMailPath);
			    	   
			    	   
			           break;
			       case 3:
			           // input format - yyyy/MM/dd (ex: 2018/09/17)
			           // code to print recipients who have birthdays on the given date
			    	   System.out.println("Input Format :  "
			       			  + "yyyy/MM/dd (ex: 2018/09/17)\n"
			       			  + "Enter Date....:\n");
			    	   Scanner input3 = new Scanner(System.in);
			    	   String input_date = input3.nextLine();
			    	   while(!input_date.matches("\\d\\d\\d\\d\\/\\d\\d\\/\\d\\d")) {
			 	  	  		System.out.println("Wrong Date Format..!!! Enter Again:");
			 	  	  	input_date = input3.nextLine();
			 	  	  	  }
			    	   requireEmailClientObj.findWhoHaveBday(input_date);
			    	   
			           break;
			       case 4:
			           // input format - yyyy/MM/dd (ex: 2018/09/17)
			           // code to print the details of all the emails sent on the input date
			    	   System.out.println("Input Format :  "
			    			   + "yyyy/MM/dd (ex: 2018/09/17)\n"
			    			   + "Enter Date....:\n");
			    	   Scanner input4 = new Scanner(System.in);
			    	   String date_email = input4.nextLine();
			    	   while(!date_email.matches("\\d\\d\\d\\d\\/\\d\\d\\/\\d\\d")) {
			 	  	  		System.out.println("Wrong Date Format..!!! Enter Again:");
			 	  	  		date_email = input4.nextLine();
			 	  	  	  }
			    	   FindSentMail.findSendMail(date_email, sentMailPath);
			           break;
			       case 5:
			           // code to print the number of recipient objects in the application
			    	   System.out.println("Number of recipient objects in the application : " + Recipient.getObjectCount()+"\n");
			           break;
			       default:
			    	   System.out.println("Invalid Input.!!!\n");
			    	   
			 	}
    	
         	}
   	 	
   }  		

         // start email client
         // code to create objects for each recipient in clientList.txt
         // use necessary variables, methods and classes
   
}

//create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
