package dev.canm.payft.payment;

import dev.canm.payft.payment.EventPublicationRegistryTests.FailingAsyncTransactionalEventListener;
import dev.canm.payft.payment.internal.Payment;
import dev.canm.payft.payment.internal.PaymentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.annotation.DirtiesContext;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
@Import(FailingAsyncTransactionalEventListener.class)
@DirtiesContext
@RequiredArgsConstructor
class EventPublicationRegistryTests {

    private final PaymentService paymentService;
    private final EventPublicationRegistry registry;
    private final FailingAsyncTransactionalEventListener listener;

    @Test
    void leavesPublicationIncompleteForFailingListener(Scenario scenario) {
        Payment payment = Payment.of(new Payment.PaymentIdentifier(UUID.randomUUID()));
        scenario.stimulate(() -> paymentService.receive(payment))
                .andWaitForStateChange(listener::getEx)
                .andVerify(__ -> assertThat(registry.findIncompletePublications()).hasSize(1));
    }

    static class FailingAsyncTransactionalEventListener {

        @Getter
        Exception ex;

        @ApplicationModuleListener
        void on(PaymentReceived event) {
            var exception = new IllegalStateException("Failing miserably! paymentId: %s".formatted(event.paymentId()));
            try {
                throw exception;
            } finally {
                this.ex = exception;
            }
        }
    }

}
