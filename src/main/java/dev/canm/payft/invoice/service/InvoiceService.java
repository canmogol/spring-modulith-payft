package dev.canm.payft.invoice.service;

import dev.canm.payft.invoice.event.InvoiceIssued;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    private final @NonNull ApplicationEventPublisher events;

    @SneakyThrows
    public void issueInvoice(UUID paymentId) {
        log.debug("Received payment, issuing invoice for payment {}", paymentId);
        // issue invoice
        Thread.sleep(1000);
        log.debug("Publishing InvoiceIssued event for payment {}", paymentId);
        // publish InvoiceIssued event
        events.publishEvent(new InvoiceIssued(UUID.randomUUID()));
        log.debug("InvoiceIssued event published for payment {}", paymentId);
    }
}
