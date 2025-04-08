package ui;

import ams.Flight;
import ams.Flight.MealOption;
import ams.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class BookingScreen extends JFrame {
    private JComboBox<String> flightDropdown;
    private JComboBox<String> seatClassDropdown;
    private JComboBox<MealOption> mealDropdown;

    private Map<String, Flight> flightMap = new HashMap<>();
    private User user;

    public BookingScreen(User user) {
        this.user = user;

        setTitle("Book a Flight");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Mock flights
        generateMockFlights();

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Select Flight:"));
        flightDropdown = new JComboBox<>(flightMap.keySet().toArray(new String[0]));
        panel.add(flightDropdown);

        panel.add(new JLabel("Seat Class:"));
        seatClassDropdown = new JComboBox<>(new String[]{"Economy", "Business"});
        panel.add(seatClassDropdown);

        panel.add(new JLabel("Meal Option:"));
        mealDropdown = new JComboBox<>(MealOption.values());
        panel.add(mealDropdown);

        JButton bookButton = new JButton("Book Flight");
        bookButton.addActionListener(this::bookFlight);
        panel.add(bookButton);

        add(panel);
        setVisible(true);
    }

    private void generateMockFlights() {
        Flight flight1 = new Flight("FL123", "New York", "London",
                LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(7),
                1, "12A", 500,
                Map.of("Economy", 100, "Business", 50),
                List.of(MealOption.VEG, MealOption.NON_VEG));

        flightMap.put(flight1.getFlightId(), flight1);
    }

    private void bookFlight(ActionEvent e) {
        String flightId = (String) flightDropdown.getSelectedItem();
        String seatClass = (String) seatClassDropdown.getSelectedItem();
        MealOption meal = (MealOption) mealDropdown.getSelectedItem();

        JOptionPane.showMessageDialog(this,
                "Flight booked!\nUser: " + user.getName() + "\nFlight: " + flightId +
                        "\nSeat Class: " + seatClass + "\nMeal: " + meal);
        // Real booking object can be created and stored later
    }
}
