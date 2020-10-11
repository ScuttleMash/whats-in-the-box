package be.aca.witb.domain.api.order;

import static be.aca.witb.utility.validation.Validator.isNotEmpty;
import static be.aca.witb.utility.validation.Validator.isNotNull;

import java.util.List;

import be.aca.witb.domain.api.customer.CustomerIdentifier;

public final class CreateOrderRequest {

	private final CustomerIdentifier customerIdentifier;
	private final List<OrderLineRequest> orderLineRequests;

	public CreateOrderRequest(CustomerIdentifier customerIdentifier, List<OrderLineRequest> orderLineRequests) {
		isNotNull(customerIdentifier);
		isNotNull(orderLineRequests);
		isNotEmpty(orderLineRequests);

		this.customerIdentifier = customerIdentifier;
		this.orderLineRequests = orderLineRequests;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return customerIdentifier;
	}

	public List<OrderLineRequest> getOrderLineRequests() {
		return orderLineRequests;
	}
}
