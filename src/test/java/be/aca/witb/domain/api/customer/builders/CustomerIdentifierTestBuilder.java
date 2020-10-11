package be.aca.witb.domain.api.customer.builders;

import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import be.aca.witb.domain.api.customer.CustomerIdentifier;

public final class CustomerIdentifierTestBuilder {

	public static CustomerIdentifier aCustomerIdentifier() {
		return new CustomerIdentifier(randomUUID(), nextInt());
	}
}
