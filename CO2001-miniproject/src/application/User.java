package application;

import java.io.Serializable;


public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private long userID;
	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	
//	public User( ) {
//        this("unknown", "unknown", 0, "unknown", "unknown","unknown","unknown");
//    }
	
	public User(String username, String password, String firstName,String lastName, String age, String gender){
		this.username = username;
		this.password = password;
//		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.age = age;
		this.gender = gender;
	}

	public User() {
		// TODO Auto-generated constructor stub
		
	}
	
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender != "male" || gender != "female" ) {
            throw new IllegalArgumentException();
        } else {
		this.gender = gender;
        }
	}

	
}
