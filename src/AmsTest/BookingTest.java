package amsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ams.Booking;
import ams.Flight;
import ams.User;
import ams.Booking.BookingStatus;

import java.time.LocalDateTime;

public class BookingTest {

    @Test
    public void testBookingNoArgConstructor() {
        Booking booking = new Booking();
        Assertions.assertNotNull(booking, "Booking object should not be null");
    }

    @Test
    public void testBookingParameterizedConstructor() {
        User user = new User("U100", "TestUser", "test@example.com", "test123");
        Flight flight = new Flight(); // assuming a parameterized constructor exists
        LocalDateTime now = LocalDateTime.now();

        Booking booking = new Booking("B001", user, flight, now, BookingStatus.CONFIRMED);

        Assertions.assertEquals("B001", booking.getBookingId());
        Assertions.assertEquals(user, booking.getUser());
        Assertions.assertEquals(flight, booking.getFlight());
        Assertions.assertEquals(now, booking.getBookingDate());
        Assertions.assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
    }
}
