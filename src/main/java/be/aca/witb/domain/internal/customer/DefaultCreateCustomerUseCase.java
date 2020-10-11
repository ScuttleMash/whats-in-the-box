package be.aca.witb.domain.internal.customer;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.customer.CustomerIdentifier;

public class DefaultCreateCustomerUseCase implements CreateCustomerUseCase {

	private final DefaultCustomerRepository customerRepository;

	public DefaultCreateCustomerUseCase() {
		this.customerRepository = new DefaultCustomerRepository();
	}

	@Override
	public CustomerIdentifier execute(CreateCustomerRequest request) {
		isNotNull(request);

		return customerRepository.save(new CustomerEntity(request)).getIdentifier();
	}
}
