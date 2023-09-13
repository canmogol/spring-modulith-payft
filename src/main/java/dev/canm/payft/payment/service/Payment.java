package dev.canm.payft.payment.service;

import lombok.*;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Payment implements AggregateRoot<Payment, Payment.PaymentIdentifier> {

    private PaymentIdentifier id = new PaymentIdentifier(UUID.randomUUID());

    public record PaymentIdentifier(UUID id) implements Identifier {
    }
}
