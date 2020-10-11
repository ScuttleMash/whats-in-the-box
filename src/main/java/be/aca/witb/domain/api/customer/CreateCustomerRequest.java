package be.aca.witb.domain.api.customer;

import static be.aca.witb.domain.utility.validation.Validator.isNotNull;

public final class CreateCustomerRequest {

	private final CustomerName customerName;

	public CreateCustomerRequest(CustomerName customerName) {
		isNotNull(customerName);

		this.customerName = customerName;
	}

	public CustomerName getName() {
		return customerName;
	}
}
