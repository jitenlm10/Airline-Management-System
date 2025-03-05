package AmsTest;

import Ams.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testUserNoArgConstructor() {
        User user = new User();
        Assertions.assertNotNull(user, "User object should not be null");
    }

    @Test
    public void testUserParameterizedConstructor() {
        User user = new User("U001", "Alice", "alice@example.com", "secret123");

        Assertions.assertEquals("U001", user.getUserId());
        Assertions.assertEquals("Alice", user.getName());
        Assertions.assertEquals("alice@example.com", user.getEmail());
        Assertions.assertEquals("secret123", user.getPassword());
    }
}
