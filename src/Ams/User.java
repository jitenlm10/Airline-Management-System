package ams;

import java.util.regex.Pattern;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;

    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$";
    
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public User() {
        
    }
    
    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        setPassword(password);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException(
                "Password must be at least 10 characters long and contain an uppercase letter, " +
                "a lowercase letter, a number, and a special character."
            );
        }
        this.password = password;
    }

    private boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
