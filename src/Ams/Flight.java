package ams;

import java.time.LocalDateTime;
import java.util.List;


public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private String seatNumber;
    private int price;

   
    private List<SeatCategory> seatCategories;

    
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
                  int totalSeats,
                  String seatNumber,
                  List<SeatCategory> seatCategories,
                  List<MealOption> mealOptions) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.seatNumber = seatNumber;
        this.seatCategories = seatCategories;
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

	public int getTotalSeats() {
		return totalSeats;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public int getPrice() {
		return price;
	}

	public List<SeatCategory> getSeatCategories() {
		return seatCategories;
	}

	public List<MealOption> getMealOptions() {
		return mealOptions;
	}

	public enum SeatCategory {
        ECONOMY,
        BUSINESS,
        FIRST
    }

    public enum MealOption {
        VEG,
        NON_VEG,
        VEGAN,
        KOSHER,
        HALAL
    }
}

