package amsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ams.Customer;

public class CustomerTest {

    @Test
    public void testCustomerNoArgConstructor() {
        Customer customer = new Customer();
        Assertions.assertNotNull(customer, "Customer object should not be null");
    }

    @Test
    public void testCustomerParameterizedConstructor() {
        Customer customer = new Customer("C001", "John Doe", "john@example.com", "mypassword", 200);

        Assertions.assertEquals("C001", customer.getUserId());
        Assertions.assertEquals("John Doe", customer.getName());
        Assertions.assertEquals("john@example.com", customer.getEmail());
        Assertions.assertEquals("mypassword", customer.getPassword());
        Assertions.assertEquals(200, customer.getLoyaltyPoints());
    }
}
