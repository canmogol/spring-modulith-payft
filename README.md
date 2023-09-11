# PayFT a Spring Modulith
A Spring Modulith example.

## Components
Components, payment and invoice.

![Components, payment and invoice](docs/components.png)

## Modules
There are two modules in this example, payment and invoice.

### Payment module.
![Payment module](docs/module-payment.png)

|                                                                                            |
|--------------------------------------------------------------------------------------------|
| Base package                                                                               |
| `dev.canm.payft.payment`                                                                   |
| Published events                                                                           |
| \* `d.c.p.p.PaymentReceived` created by: \*\* `d.c.p.p.internal.PaymentService.receive(…)` |


### Invoice module.
![Invoice module](docs/module-invoice.png)

|                                                                                               |
|-----------------------------------------------------------------------------------------------|
| Base package                                                                                  |
| `dev.canm.payft.invoice`                                                                      |
| Published events                                                                              |
| \* `d.c.p.i.InvoiceIssued` created by: \*\* `d.c.p.i.internal.InvoiceService.issueInvoice(…)` |
| Events listened to                                                                            |
| \* `d.c.p.p.PaymentReceived`                                                                  |
