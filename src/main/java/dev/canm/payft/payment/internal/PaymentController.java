package dev.canm.payft.payment.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping("/complete")
    public void complete(PaymentDto dto) {
        Payment payment = Payment.of(new Payment.PaymentIdentifier(dto.id()));
        service.receive(payment);
    }
}
