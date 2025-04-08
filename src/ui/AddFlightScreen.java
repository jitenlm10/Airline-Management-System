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

public class AddFlightScreen extends JFrame {
    private JTextField flightIdField, originField, destinationField, departureField, arrivalField;
    private JTextField seatsField, seatNumberField, priceField;
    private JCheckBox vegBox, nonVegBox, veganBox, kosherBox, halalBox;
    private User user;

    public AddFlightScreen(User user) {
        this.user = user;
        setTitle("Add Flight");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10));

        flightIdField = addTextField(panel, "Flight ID:");
        originField = addTextField(panel, "Origin:");
        destinationField = addTextField(panel, "Destination:");
        departureField = addTextField(panel, "Departure (yyyy-MM-ddTHH:mm):");
        arrivalField = addTextField(panel, "Arrival (yyyy-MM-ddTHH:mm):");
        seatsField = addTextField(panel, "Seats:");
        seatNumberField = addTextField(panel, "Seat Number:");
        priceField = addTextField(panel, "Price:");

        panel.add(new JLabel("Meal Options:"));
        JPanel mealPanel = new JPanel(new GridLayout(1, 5));
        vegBox = new JCheckBox("VEG");
        nonVegBox = new JCheckBox("NON_VEG");
        veganBox = new JCheckBox("VEGAN");
        kosherBox = new JCheckBox("KOSHER");
        halalBox = new JCheckBox("HALAL");

        mealPanel.add(vegBox);
        mealPanel.add(nonVegBox);
        mealPanel.add(veganBox);
        mealPanel.add(kosherBox);
        mealPanel.add(halalBox);
        panel.add(mealPanel);

        JButton addButton = new JButton("Add Flight");
        addButton.addActionListener(this::addFlight);
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    private JTextField addTextField(JPanel panel, String label) {
        panel.add(new JLabel(label));
        JTextField field = new JTextField();
        panel.add(field);
        return field;
    }

    private void addFlight(ActionEvent e) {
        try {
            String flightId = flightIdField.getText();
            String origin = originField.getText();
            String destination = destinationField.getText();
            LocalDateTime departure = LocalDateTime.parse(departureField.getText());
            LocalDateTime arrival = LocalDateTime.parse(arrivalField.getText());
            int seats = Integer.parseInt(seatsField.getText());
            String seatNumber = seatNumberField.getText();
            int price = Integer.parseInt(priceField.getText());

            List<MealOption> selectedMeals = new ArrayList<>();
            if (vegBox.isSelected()) selectedMeals.add(MealOption.VEG);
            if (nonVegBox.isSelected()) selectedMeals.add(MealOption.NON_VEG);
            if (veganBox.isSelected()) selectedMeals.add(MealOption.VEGAN);
            if (kosherBox.isSelected()) selectedMeals.add(MealOption.KOSHER);
            if (halalBox.isSelected()) selectedMeals.add(MealOption.HALAL);

            Map<String, Integer> seatClasses = new HashMap<>();
            seatClasses.put("Economy", 50);
            seatClasses.put("Business", 20);

            Flight flight = new Flight(flightId, origin, destination, departure, arrival, seats, seatNumber, price, seatClasses, selectedMeals);
            JOptionPane.showMessageDialog(this, "Flight added: " + flight.getFlightId());
            // You can add flight to a database or list later

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
