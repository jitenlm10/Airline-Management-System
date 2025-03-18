package amsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ams.Payment;
import ams.Payment.PaymentStatus;

import java.time.LocalDateTime;

public class PaymentTest {

    @Test
    public void testPaymentNoArgConstructor() {
        Payment payment = new Payment();
        Assertions.assertNotNull(payment, "Payment object should not be null");
    }

    @Test
    public void testPaymentParameterizedConstructor() {
        LocalDateTime now = LocalDateTime.now();

        Payment payment = new Payment("P001", 299.99, PaymentStatus.PAID, now);

        Assertions.assertEquals("P001", payment.getPaymentId());
        Assertions.assertEquals(299.99, payment.getAmount(), 0.0001);
        Assertions.assertEquals(PaymentStatus.PAID, payment.getStatus());
        Assertions.assertEquals(now, payment.getPaymentDate());
    }
}
