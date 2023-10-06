package email_Client;

public abstract class Recipient {
	private String type;
	private String name;
	private String email;
	private static int objectCount;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static int getObjectCount() {
		return objectCount;
	}
	public static void setObjectCount(int objectCount) {
		Recipient.objectCount = objectCount;
	}
	public Recipient(String name, String email) {
		this.name = name;
		this.email = email;
		objectCount++;
	}

}
