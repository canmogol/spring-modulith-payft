package dev.canm.payft.invoice.listener;

import dev.canm.payft.invoice.service.InvoiceService;
import dev.canm.payft.payment.event.PaymentReceived;
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
