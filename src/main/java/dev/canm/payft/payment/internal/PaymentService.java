package dev.canm.payft.payment.internal;

import dev.canm.payft.payment.PaymentReceived;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final @NonNull ApplicationEventPublisher events;

    @SneakyThrows
    @Transactional
    public void receive(Payment payment) {
        log.debug("Received payment {}", payment.getId());
        // process payment
        Thread.sleep(1000);
        log.debug("Publishing PaymentReceived event for payment {}", payment.getId());
        // publish PaymentReceived event
        events.publishEvent(new PaymentReceived(payment.getId().id()));
    }
}
