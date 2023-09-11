package dev.canm.payft;

import dev.canm.payft.payment.internal.Payment;
import dev.canm.payft.payment.internal.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ApplicationIntegrationTests {

    @Autowired
    private PaymentService paymentService;

    @Test
    void receivesPayments() throws InterruptedException {
        Payment payment = Payment.of(new Payment.PaymentIdentifier(UUID.randomUUID()));
        assertDoesNotThrow(() -> paymentService.receive(payment));
        // let the event be processed
        Thread.sleep(2000);
    }
}
