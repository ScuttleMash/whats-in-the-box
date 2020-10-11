package be.aca.witb.domain.api.customer.builders;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import be.aca.witb.domain.api.customer.CustomerName;

public class CustomerNameTestBuilder {

	private static final int MIN_LENGTH_INCLUSIVE = 1;
	private static final int MAX_LENGTH_EXCLUSIVE = 31;

	private CustomerNameTestBuilder() { }

	public static CustomerName aCustomerName() {
		return new CustomerName(randomAlphanumeric(MIN_LENGTH_INCLUSIVE, MAX_LENGTH_EXCLUSIVE));
	}
}
