package dev.canm.payft.invoice.internal;

import dev.canm.payft.payment.PaymentReceived;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
class PaymentReceivedListener {

    private final InvoiceService invoiceService;

    @ApplicationModuleListener
    void on(PaymentReceived paymentReceivedEvent) {
        log.debug("Received payment {}", paymentReceivedEvent.paymentId());
        UUID paymentId = paymentReceivedEvent.paymentId();
        invoiceService.issueInvoice(paymentId);
    }
}
