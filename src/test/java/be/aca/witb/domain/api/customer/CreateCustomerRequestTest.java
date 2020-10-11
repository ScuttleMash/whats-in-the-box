package be.aca.witb.domain.api.customer;

import static be.aca.witb.domain.api.customer.builders.CustomerNameTestBuilder.aCustomerName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.domain.utility.validation.exceptions.ObjectIsNullException;

public class CreateCustomerRequestTest {

	@Test
	public void createsRequestWithValidParameters() {
		CustomerName customerName = aCustomerName();
		CreateCustomerRequest request = new CreateCustomerRequest(customerName);

		assertThat(request.getName().getValue()).isEqualTo(customerName.getValue());
	}

	@Test
	public void throwsExceptionWhenCustomerNameIsNull() {
		assertThatThrownBy(() -> new CreateCustomerRequest(null)).isInstanceOf(ObjectIsNullException.class);
	}
}
