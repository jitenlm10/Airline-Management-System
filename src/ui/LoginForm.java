package ui;

import javax.swing.*;

import ams.User;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private User registeredUser; // Holds the registered user

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
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (registeredUser == null) {
            JOptionPane.showMessageDialog(this, "No registered user. Please register first.");
        } else if (registeredUser.getEmail().equals(email) &&
                   registeredUser.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful! Welcome " + registeredUser.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRegistrationForm(ActionEvent e) {
        dispose(); // Close login window
        new RegistrationForm(this); // Pass this frame to registration
    }

    // Called from RegistrationForm to pass back the user
    public void setRegisteredUser(User user) {
        this.registeredUser = user;
        this.setVisible(true); // Show login again
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}
