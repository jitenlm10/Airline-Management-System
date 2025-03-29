package ui;

import ams.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {
    private JTextField userIdField, nameField, emailField;
    private JPasswordField passwordField;
    private JTextField loyaltyPointsField, companyNameField, businessAccountIdField, employeeIdField;
    private JComboBox<String> userTypeCombo;
    private LoginForm loginForm;

    public RegistrationForm(LoginForm loginForm) {
        this.loginForm = loginForm;

        setTitle("User Registration");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        panel.add(new JLabel("User Type:"));
        userTypeCombo = new JComboBox<>(new String[]{"Customer", "BusinessCustomer", "AirlineAgent"});
        userTypeCombo.addActionListener(_ -> updateUserTypeFields());
        panel.add(userTypeCombo);

        panel.add(new JLabel("User ID:"));
        userIdField = new JTextField();
        panel.add(userIdField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Dynamic Fields
        panel.add(new JLabel("Loyalty Points (Customer):"));
        loyaltyPointsField = new JTextField();
        panel.add(loyaltyPointsField);

        panel.add(new JLabel("Company Name (BusinessCustomer):"));
        companyNameField = new JTextField();
        panel.add(companyNameField);

        panel.add(new JLabel("Business Account ID (BusinessCustomer):"));
        businessAccountIdField = new JTextField();
        panel.add(businessAccountIdField);

        panel.add(new JLabel("Employee ID (AirlineAgent):"));
        employeeIdField = new JTextField();
        panel.add(employeeIdField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(this::registerUser);
        panel.add(registerButton);

        add(panel);
        updateUserTypeFields(); // hide/show fields
        setVisible(true);
    }

    private void updateUserTypeFields() {
        String selected = (String) userTypeCombo.getSelectedItem();

        loyaltyPointsField.setEnabled("Customer".equals(selected));
        companyNameField.setEnabled("BusinessCustomer".equals(selected));
        businessAccountIdField.setEnabled("BusinessCustomer".equals(selected));
        employeeIdField.setEnabled("AirlineAgent".equals(selected));
    }

    private void registerUser(ActionEvent e) {
        String userId = userIdField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String userType = (String) userTypeCombo.getSelectedItem();

        try {
            User user = null;

            switch (userType) {
                case "Customer":
                    int points = Integer.parseInt(loyaltyPointsField.getText());
                    user = new Customer(userId, name, email, password, points);
                    break;

                case "BusinessCustomer":
                    String company = companyNameField.getText();
                    String accountId = businessAccountIdField.getText();
                    user = new BusinessCustomer(userId, name, email, password, company, accountId);
                    break;

                case "AirlineAgent":
                    String employeeId = employeeIdField.getText();
                    user = new AirlineAgent(userId, name, email, password, employeeId);
                    break;
            }

            JOptionPane.showMessageDialog(this, "Registration successful for " + user.getName());
            loginForm.setRegisteredUser(user);
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Loyalty Points must be a number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
}
