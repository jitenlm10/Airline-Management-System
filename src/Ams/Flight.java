package ams;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int Seats; // number of passengers in one booking
    private String seatNumber;
    private int price;
    private Map<String, Integer> seatClasses;


    private List<MealOption> mealOptions;
	

    // No-arg (default) constructor
    public Flight() {
        
    }

    // Parameterized constructor
    public Flight(String flightId,
                  String origin,
                  String destination,
                  LocalDateTime departureTime,
                  LocalDateTime arrivalTime,
                  int Seats,
                  String seatNumber,
                  int price,
                  Map<String, Integer> seatClasses,
                  List<MealOption> mealOptions) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.Seats = Seats;
        this.seatNumber = seatNumber;
        this.price = price;
        this.seatClasses = seatClasses;
        this.mealOptions = mealOptions;
    }


	public String getFlightId() {
		return flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public int getSeats() {
		return Seats;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public int getPrice() {
		return price;
	}

	public Map<String, Integer> getSeatClasses() {
		return seatClasses;
	}

	public List<MealOption> getMealOptions() {
		return mealOptions;
	}


	public enum MealOption {
        VEG,
        NON_VEG,
        VEGAN,
        KOSHER,
        HALAL
    }
}

