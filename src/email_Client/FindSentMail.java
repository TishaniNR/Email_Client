package email_Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FindSentMail {
	private static ArrayList<String> sentMailClientList = new ArrayList<>();
	
	//Finding is there any mails have sent on entered day by reading sentMail file
	public static void findSendMail(String date, String file_name) {
		
		try {
			File clientFile = new File(file_name);
			FileReader fileReader = new FileReader(clientFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			boolean foundSentMail = false;
			while ((data = bufferedReader.readLine()) != null) {
				if (!data.equals("")) {
					//System.out.println(data);
					
					sentMailClientList.add(data);
					
					String[] clientList = data.split(",",0);
					if ((clientList[clientList.length-1]).equals(date)) {
						foundSentMail = true;
						System.out.println(clientList[0]+ "," + clientList[1]+ "," + clientList[2]);
						
					}
				}
			}
			
			if (!foundSentMail) {
				System.out.println("No Emails Found on given date");	
			}
			
			bufferedReader.close();
		
		} catch (IOException e) {
			
		}
		
	}
	
	
	
	//serialization sentMailClientList
	public void saveSentMailListToHardDisk() {
		try {
				FileOutputStream fileOutputStream = new FileOutputStream("sentEmailListFile.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(sentMailClientList);
				objectOutputStream.close();
				fileOutputStream.close();
			}catch (IOException e){
				e.printStackTrace();
				}
			}
			
	// deserialization sentMailClientList
	@SuppressWarnings({ "unchecked", "unused" })
	private void retrieveSentEmailList() {
		try {
				FileInputStream fileInputStream = new FileInputStream("sentEmailListFile.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				sentMailClientList = (ArrayList<String>) objectInputStream.readObject();
				objectInputStream.close();
			}catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
				}
			}
	
}
