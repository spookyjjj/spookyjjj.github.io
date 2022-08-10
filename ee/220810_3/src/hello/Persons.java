package hello;

public class Persons {
	private String firstname;
	private String lastname;
	private int age;
	private String email;
	public Persons(String firstname, String lastname, int age, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return firstname + " " + lastname + ", 나이: " + age + ", 이메일: " + email;
	}
	
}
