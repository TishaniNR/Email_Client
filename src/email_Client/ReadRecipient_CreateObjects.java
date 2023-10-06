/*package email_Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadRecipient_CreateObjects {
	public static void ReadClientListFile(String file_name,ArrayList<Recipient> clientList) {
		try {
			File clientFile = new File(file_name);
			FileReader fileReader = new FileReader(clientFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			while ((data = bufferedReader.readLine()) != null) {
				if (!data.equals("")) {
					clientList.add(createRecipientObjects(data));
				}
			}
			bufferedReader.close();
		
		} catch (IOException e) {
			
		}
	}
	//create recipient objects
	private Object createRecipientObjects (String data) {
			
			switch(clientList[0]) {
			String[] clientList = data.split(":",2);
 	   		String[] dataList = clientList[1].split(",");
			case "Official":
				official_recipient = new OfficeRecipient(dataList[0],dataList[1],dataList[2]);
				return official_recipient;
				
			case "Office_friend":
				office_friend_recipient = new Office_friend(dataList[0],dataList[1],dataList[2],dataList[3]);
				return office_friend_recipient;
				
			case "Personal":
				personal_recipient = new PersonalRecipient(dataList[0],dataList[1],dataList[2],dataList[3]);
				return personal_recipient;
				
			default:
				System.out.println("Invalid entry found");
				return null;
			}

}

*
*
*
*
*
*
*
*
*
*
//Update sentEmailsList
	public void updateSentMail(String subject, String email){
		try {
			if(sentEmails.containsKey(curentDate)){
				sentEmails.get(curentDate).add(subject+" , "+email);
			}
			else {
				ArrayList<String> sentEmailDetails = new ArrayList<String>();
				sentEmailDetails.add(subject+" , "+email);
				sentEmails.put(curentDate, sentEmailDetails);
			}
		}catch(NullPointerException e) {
			ArrayList<String> sentEmailDetails = new ArrayList<String>();
			sentEmailDetails.add(subject+" , "+email);
			sentEmails.put(curentDate, sentEmailDetails);
		}
	}*/
