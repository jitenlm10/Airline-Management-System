package Ams;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;

    // No-arg constructor
    public User() {
        
    }
    
	// Parameterized constructor 
    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
    
    
}

