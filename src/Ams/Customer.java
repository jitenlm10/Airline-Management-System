package Ams;

public class Customer extends User {
	private int loyaltyPoints;

    // No-arg constructor
    public Customer() {
        super();
    }

    // Parameterized constructor
    public Customer(String userId, String name, String email, String password,
                    int loyaltyPoints) {
        super(userId, name, email, password);
        this.loyaltyPoints = loyaltyPoints;
    }

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}
    
    
}

