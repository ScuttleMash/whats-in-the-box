package be.aca.witb.domain.api.customer.mothers;

import static be.aca.witb.domain.api.customer.builders.CreateCustomerRequestTestBuilder.aCreateCustomerRequestTestBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.customer.CustomerIdentifier;

@Component
public class CustomerMother {

	private final CreateCustomerUseCase createCustomerUseCase;

	private CustomerIdentifier identifier;

	@Autowired
	public CustomerMother(CreateCustomerUseCase createCustomerUseCase) {
		this.createCustomerUseCase = createCustomerUseCase;
	}

	public void setup() {
		CreateCustomerRequest request = aCreateCustomerRequestTestBuilder().build();
		identifier = createCustomerUseCase.execute(request);
	}

	public CustomerIdentifier getIdentifier() {
		return identifier;
	}
}
