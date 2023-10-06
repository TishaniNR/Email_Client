package email_Client;

public class OfficeRecipient extends Recipient {
	private String designation;

	public String getDesgnation() {
		return designation;
	}

	public void setDesgnation(String desgnation) {
		this.designation = desgnation;
	}
	
	public OfficeRecipient(String name, String email,String designation) {
		super(name, email);
		this.designation = designation;
	}

}
