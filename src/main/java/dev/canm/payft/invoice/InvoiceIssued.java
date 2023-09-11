package dev.canm.payft.invoice;

import org.jmolecules.event.types.DomainEvent;

import java.util.UUID;

public record InvoiceIssued(UUID invoiceId) implements DomainEvent {
}

