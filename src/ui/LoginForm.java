package ui;

import javax.swing.*;

import ams.User;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this::loginUser);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(this::openRegistrationForm);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    private void loginUser(ActionEvent e) {
        String mockUserType = "Customer"; // Change to "Customer" or "BusinessCustomer" to test BookingScreen

        // Create a dummy user
        ams.User dummyUser = switch (mockUserType) {
            case "Customer" -> new ams.Customer("C001", "Alice", "alice@example.com", "Password@123", 1200);
            case "BusinessCustomer" -> new ams.BusinessCustomer("B001", "Bob", "bob@biz.com", "Password@123", "TechCorp", "ACC123");
            default -> new ams.AirlineAgent("A001", "Agent Smith", "agent@airline.com", "Password@123", "EMP001");
        };

        // Launch the corresponding screen
        if (dummyUser instanceof ams.AirlineAgent) {
            new AddFlightScreen(dummyUser);
        } else {
            new BookingScreen(dummyUser);
        }

        dispose(); // Close login screen
    }

    private void openRegistrationForm(ActionEvent e) {
        dispose(); // Close login window
        new RegistrationForm(this); // Pass this frame to registration
    }

    // Called from RegistrationForm to pass back the user
    public void setRegisteredUser(User user) {
        this.setVisible(true); // Show login again
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}
