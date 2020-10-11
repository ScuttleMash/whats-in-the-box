package be.aca.witb.domain.internal.customer.asserts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZonedDateTime;

import org.assertj.core.api.AbstractAssert;

import be.aca.witb.domain.internal.customer.CustomerEntity;

public class UglyCustomerAssert extends AbstractAssert<UglyCustomerAssert, CustomerEntity> {

	public UglyCustomerAssert(CustomerEntity customer) {
		super(customer, UglyCustomerAssert.class);
	}

	public void wasRegisteredOn(ZonedDateTime now) {
		assertThat(actual.getRegisteredOn()).isEqualToIgnoringHours(now);
	}

	public static UglyCustomerAssert assertThatCustomer(CustomerEntity customer) {
		assertThat(customer).isNotNull();
		return new UglyCustomerAssert(customer);
	}
}


