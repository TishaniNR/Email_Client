package email_Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RequireEmailClient {

	private ArrayList<Recipient> clientList = new ArrayList<>();
	private ArrayList<BirthdayGreeting> BirthdayGreetingList = new ArrayList<>();
	
	
	private String currentDate;
	//create recipient objects
		private Recipient createRecipientObjects (String data) {
	    		String[] clientList = data.split(":",2);
	 	   		String[] dataList = clientList[1].split(",");
	 	   		Recipient recipientObj;
	 	   		
				switch(clientList[0]) {
				case "Official":
					recipientObj = new OfficeRecipient(dataList[0],dataList[1],dataList[2]);
					//System.out.println("Object Created");
					return recipientObj;
					
				case "Office_friend":
					recipientObj = new Office_friend(dataList[0],dataList[1],dataList[2],dataList[3]);
					BirthdayGreetingList.add((BirthdayGreeting)recipientObj);
					//System.out.println("Object Created");
					return recipientObj;
					
				case "Personal":
					recipientObj = new PersonalRecipient(dataList[0],dataList[1],dataList[2],dataList[3]);
					BirthdayGreetingList.add((BirthdayGreeting)recipientObj);
					//System.out.println("Object Created");
					return recipientObj;
					
				default:
					System.out.println("Invalid entry found");
					return null;
				}
		}	
    public void readClientFile(String file_name) {

   	 try {
			File clientFile = new File(file_name);
			FileReader fileReader = new FileReader(clientFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			while ((data = bufferedReader.readLine()) != null) {
				if (!data.equals("")) {
					//System.out.println(data);
					clientList.add(createRecipientObjects(data));
				}
			}
			bufferedReader.close();
		
		} catch (IOException e) {
			
		}
   	 
    }
	//method to send birthday greeting on the correct day for recipient who has birthday on current day
	private void sendGreetingEmail() {
		for(BirthdayGreeting birthdayObj: BirthdayGreetingList ) {
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
			currentDate = formatDate.format(new Date());
			//System.out.println(curentDate.substring(5));
			if (birthdayObj.getBirthday().substring(5).equals(currentDate.substring(5))) {
				Recipient recip = (Recipient)birthdayObj;
				SendMail.sendMail(recip.getEmail(), ("Happy Birthday"), birthdayObj.getBirthdayWish());
				UpdateSentMailList.updateSentMail("Happy Birthday", recip.getEmail(), recip.getName(), currentDate, "D:\\UoM\\CSE\\Semester02\\CS1040 Program Construction\\Email_Client_Assignment\\sentEmailsList.txt");
			}	
		}	
		System.out.println("Birthday wishes are sent who has birthday Today!\n");
	}    
    
    public void startEmailClient() {
		System.out.println("Email Client is Running..!!\n"
				+ "Please wait...");
		try {
				sendGreetingEmail();
				
		}catch(NullPointerException e) {
			
		}
		
	}

	//print who has birthday on entered day
	public void findWhoHaveBday(String Enter_day) {
		boolean haveBirthday = false;
		for(BirthdayGreeting birthdayObj: BirthdayGreetingList ) {
			if (birthdayObj.getBirthday().substring(5).equals(Enter_day.substring(5))) {
				Recipient recipient1 = (Recipient)birthdayObj;
				System.out.println(recipient1.getName());
				haveBirthday = true;
			}
		}
		if (!haveBirthday) {
			System.out.println("No birthdays on "+ Enter_day + "\n");
		}
	}

}
