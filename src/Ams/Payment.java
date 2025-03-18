package ams;

import java.time.LocalDateTime;


public class Payment {
    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private LocalDateTime paymentDate;

    // No-arg (default) constructor
    public Payment() {
       
    }

    // Parameterized constructor
    public Payment(String paymentId, double amount, PaymentStatus status,
    		LocalDateTime paymentDate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    
    public String getPaymentId() {
		return paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}


	public enum PaymentStatus {
        PAID,
        REFUNDED
    }
    
}
