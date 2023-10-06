package email_Client;

public class PersonalRecipient extends Recipient implements BirthdayGreeting{
	private String nickname;
	private String birthday;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public PersonalRecipient(String name, String nickname,String email,String birthday){
		super(name, email);
		this.nickname = nickname;
		this.birthday = birthday;
		
	}
	
	@Override
	public String getBirthdayWish() {
		return "Wish you a Happy Birthday and hugs and love on your birthday.  " + getName();
		}
	 

}
