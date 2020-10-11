package be.aca.witb.domain.api.customer.builders;

import static be.aca.witb.domain.api.customer.builders.CustomerNameTestBuilder.aCustomerName;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CustomerName;

public class CreateCustomerRequestTestBuilder {

	private CustomerName customerName;

	private CreateCustomerRequestTestBuilder() {
		customerName = aCustomerName();
	}

	public CreateCustomerRequest build() {
		return new CreateCustomerRequest(customerName);
	}

	public static CreateCustomerRequestTestBuilder aCreateCustomerRequestTestBuilder() {
		return new CreateCustomerRequestTestBuilder();
	}
}
