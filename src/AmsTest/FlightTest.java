package amsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ams.Flight;
import ams.Flight.MealOption;
import ams.Flight.SeatCategory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightTest {

    @Test
    public void testFlightNoArgConstructor() {
        Flight flight = new Flight();
        Assertions.assertNotNull(flight, "Flight object should not be null");
    }

    @Test
    public void testFlightParameterizedConstructor() {
        List<SeatCategory> seatCategories = Arrays.asList(SeatCategory.ECONOMY, SeatCategory.BUSINESS);
        List<MealOption> mealOptions = Arrays.asList(MealOption.VEG, MealOption.NON_VEG);

        LocalDateTime departure = LocalDateTime.of(2025, 5, 1, 10, 0);
        LocalDateTime arrival   = LocalDateTime.of(2025, 5, 1, 14, 0);

        Flight flight = new Flight(
                "F001", "New York", "Los Angeles", departure, arrival,
                180, "12A", seatCategories, mealOptions
        );

        Assertions.assertEquals("F001", flight.getFlightId());
        Assertions.assertEquals("New York", flight.getOrigin());
        Assertions.assertEquals("Los Angeles", flight.getDestination());
        Assertions.assertEquals(departure, flight.getDepartureTime());
        Assertions.assertEquals(arrival, flight.getArrivalTime());
        Assertions.assertEquals(180, flight.getTotalSeats());
        Assertions.assertEquals("12A", flight.getSeatNumber());
        Assertions.assertEquals(seatCategories, flight.getSeatCategories());
        Assertions.assertEquals(mealOptions, flight.getMealOptions());
    }
}
