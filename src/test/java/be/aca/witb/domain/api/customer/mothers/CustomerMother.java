package be.aca.witb.domain.api.customer.mothers;

import static be.aca.witb.domain.api.customer.builders.CreateCustomerRequestTestBuilder.aCreateCustomerRequestTestBuilder;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.customer.CustomerIdentifier;
import be.aca.witb.domain.internal.customer.DefaultCreateCustomerUseCase;

public class CustomerMother {

	private final CreateCustomerUseCase createCustomerUseCase;

	private CustomerIdentifier identifier;

	public CustomerMother() {
		this.createCustomerUseCase = new DefaultCreateCustomerUseCase();
	}

	public void setup() {
		CreateCustomerRequest request = aCreateCustomerRequestTestBuilder().build();
		identifier = createCustomerUseCase.execute(request);
	}

	public CustomerIdentifier getIdentifier() {
		return identifier;
	}
}
