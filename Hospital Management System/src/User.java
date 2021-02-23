
public class User {

	private long id;
	// add rest of the variables
	private String firstName, 
				   lastName, 
				   gender, 
				   email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// add rest of the getters & setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}