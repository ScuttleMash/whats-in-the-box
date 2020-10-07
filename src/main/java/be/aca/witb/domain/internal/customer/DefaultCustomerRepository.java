package be.aca.witb.domain.internal.customer;

import java.util.ArrayList;
import java.util.List;

import be.aca.witb.domain.api.customer.CustomerIdentifier;
import be.aca.witb.domain.internal.customer.exceptions.CustomerNotFoundException;

public class DefaultCustomerRepository {

	private static List<CustomerEntity> saved = new ArrayList<>();

	public CustomerEntity get(CustomerIdentifier identifier) {
		return saved.stream()
				.filter(customer -> customer.getIdentifier().equals(identifier))
				.findFirst()
				.orElseThrow(CustomerNotFoundException::new);
	}

	CustomerEntity save(CustomerEntity customer) {
		saved.add(customer);
		customer.bumpVersion();
		return customer;
	}
}
