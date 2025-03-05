package AmsTest;

import Ams.BusinessCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BusinessCustomerTest {

    @Test
    public void testBusinessCustomerNoArgConstructor() {
        BusinessCustomer bc = new BusinessCustomer();
        Assertions.assertNotNull(bc, "BusinessCustomer object should not be null");
    }

    @Test
    public void testBusinessCustomerParameterizedConstructor() {
        BusinessCustomer bc = new BusinessCustomer(
                "BC001", "Acme Corp", "contact@acme.com", "securePass",
                "Acme Corp", "ACME123"
        );

        Assertions.assertEquals("BC001", bc.getUserId());
        Assertions.assertEquals("Acme Corp", bc.getName());
        Assertions.assertEquals("contact@acme.com", bc.getEmail());
        Assertions.assertEquals("securePass", bc.getPassword());
        Assertions.assertEquals("Acme Corp", bc.getCompanyName());
        Assertions.assertEquals("ACME123", bc.getBusinessAccountId());
    }
}
