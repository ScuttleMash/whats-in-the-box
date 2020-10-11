package be.aca.witb.domain.api.order.builders;

import static be.aca.witb.domain.api.customer.builders.CustomerIdentifierTestBuilder.aCustomerIdentifier;
import static be.aca.witb.domain.api.order.builders.OrderLineRequestTestBuilder.anOrderLineRequestTestBuilder;
import static java.util.List.of;

import java.util.List;

import be.aca.witb.domain.api.customer.CustomerIdentifier;
import be.aca.witb.domain.api.order.CreateOrderRequest;
import be.aca.witb.domain.api.order.OrderLineRequest;

public class CreateOrderRequestTestBuilder {

	private CustomerIdentifier customerIdentifier;
	private List<OrderLineRequest> orderLineRequests;

	private CreateOrderRequestTestBuilder() {
		customerIdentifier = aCustomerIdentifier();
		orderLineRequests = of(anOrderLineRequestTestBuilder().build());
	}

	public CreateOrderRequest build() {
		return new CreateOrderRequest(customerIdentifier, orderLineRequests);
	}

	public CreateOrderRequestTestBuilder withCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
		return this;
	}

	public CreateOrderRequestTestBuilder withOrderLineRequests(List<OrderLineRequest> orderLineRequests) {
		this.orderLineRequests = orderLineRequests;
		return this;
	}

	public static CreateOrderRequestTestBuilder aCreateOrderRequestTestBuilder() {
		return new CreateOrderRequestTestBuilder();
	}

}
