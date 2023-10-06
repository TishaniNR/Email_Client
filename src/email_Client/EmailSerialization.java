/*package email_Client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class EmailSerialization {
	private HashMap<String,ArrayList<String>> sentEmailsList;

	//serialization sentMails
	public void saveSentMailListToHardDisk() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("sentEmailListFile.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(sentEmailsList);
			objectOutputStream.close();
			fileOutputStream.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	// deserialization sentMails
	@SuppressWarnings({ "unchecked", "unused" })
	private void retrieveSentEmailList() {
		try {
			FileInputStream fileInputStream = new FileInputStream("sentEmailListFile.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			sentEmailsList = (HashMap<String,ArrayList<String>>) objectInputStream.readObject();
			objectInputStream.close();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}*/