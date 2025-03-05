package Ams;

public class BusinessCustomer extends User {
    private String companyName;      
    private String businessAccountId; 

    // No-arg constructor
    public BusinessCustomer() {
        super();
    }

    // Parameterized constructor 
    public BusinessCustomer(String userId, String name, String email, String password,
                            String companyName, String businessAccountId) {
        super(userId, name, email, password);
        this.companyName = companyName;
        this.businessAccountId = businessAccountId;
    }

	public String getCompanyName() {
		return companyName;
	}

	public String getBusinessAccountId() {
		return businessAccountId;
	}
    
    
}
