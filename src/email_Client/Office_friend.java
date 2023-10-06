package email_Client;

public class Office_friend extends OfficeRecipient implements BirthdayGreeting{
	
	private String birthday;
	
	public Office_friend(String name, String email, String designation,String birthday) {
		super(name, email, designation);
		this.birthday = birthday;
	}
	
	@Override
	public String getBirthday() {
		return birthday;
	}
	
	@Override
	public String getBirthdayWish() {
		return "Wish you a Happy Birthday. " + getName();
		}

}
