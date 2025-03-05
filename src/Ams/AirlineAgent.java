package Ams;

public class AirlineAgent extends User {
    private String employeeId;  

    // No-arg constructor
    public AirlineAgent() {
        super();
    }

    // Parameterized constructor 
    public AirlineAgent(String userId, String name, String email, String password,
                        String employeeId) {
        super(userId, name, email, password);
        this.employeeId = employeeId;
    }

	public String getEmployeeId() {
		return employeeId;
	}

    
}

