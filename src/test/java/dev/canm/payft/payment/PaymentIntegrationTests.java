package dev.canm.payft.payment;

import dev.canm.payft.payment.internal.Payment;
import dev.canm.payft.payment.internal.PaymentService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.UUID;

@ApplicationModuleTest
@RequiredArgsConstructor
class PaymentIntegrationTests {

    private final PaymentService paymentService;

    @Test
    void publishesPaymentReceived(Scenario scenario) {
        var payment = Payment.of(new Payment.PaymentIdentifier(UUID.randomUUID()));
        scenario.stimulate(() -> paymentService.receive(payment))
                .andWaitForEventOfType(PaymentReceived.class)
                .matchingMappedValue(PaymentReceived::paymentId, payment.getId().id())
                .toArrive();
    }
}
