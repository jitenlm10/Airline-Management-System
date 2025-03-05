package ams;

import java.time.LocalDateTime;


public class Booking {
    private String bookingId;
    private User user;
    private Flight flight;
    private LocalDateTime bookingDate;
    private BookingStatus status;

    // No-arg (default) constructor
    public Booking() {
       
    }

    // Parameterized constructor
    public Booking(String bookingId, User user, Flight flight, LocalDateTime bookingDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.user = user;
        this.flight = flight;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    
    public String getBookingId() {
		return bookingId;
	}

	public User getUser() {
		return user;
	}

	public Flight getFlight() {
		return flight;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public BookingStatus getStatus() {
		return status;
	}


	public enum BookingStatus {
        CONFIRMED,
        CANCELED
    }
}
