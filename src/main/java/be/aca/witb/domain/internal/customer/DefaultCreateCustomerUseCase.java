package be.aca.witb.domain.internal.customer;

import static be.aca.witb.utility.modules.ModuleServiceProvider.provide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.customer.CustomerIdentifier;

@Service
public class DefaultCreateCustomerUseCase implements CreateCustomerUseCase {

	private final DefaultCustomerRepository customerRepository;

	@Autowired
	public DefaultCreateCustomerUseCase(DefaultCustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerIdentifier execute(CreateCustomerRequest request) {
		return customerRepository.save(new CustomerEntity(request)).getIdentifier();
	}

	public static CreateCustomerUseCase provider() {
		return provide(CreateCustomerUseCase.class);
	}
}
