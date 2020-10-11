package be.aca.witb.domain.internal.customer.asserts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import org.assertj.core.api.AbstractAssert;

import be.aca.witb.domain.api.customer.CustomerName;
import be.aca.witb.domain.internal.customer.CustomerEntity;

public class UglyCustomerAssert extends AbstractAssert<UglyCustomerAssert, CustomerEntity> {

	public UglyCustomerAssert(CustomerEntity customer) {
		super(customer, UglyCustomerAssert.class);
	}

	public UglyCustomerAssert hasName(CustomerName expected) {
		assertThat(actual.getIdentifier()).isEqualTo(expected.getValue());
		return this;
	}
	public static UglyCustomerAssert assertThatCustomer(CustomerEntity customer) {
		assertThat(customer).isNotNull();
		return new UglyCustomerAssert(customer);
	}
}
