package be.aca.witb.domain.api.order;

import static be.aca.witb.domain.api.customer.builders.CustomerIdentifierTestBuilder.aCustomerIdentifier;
import static be.aca.witb.domain.api.customer.builders.CustomerNameTestBuilder.aCustomerName;
import static be.aca.witb.domain.api.order.builders.ProductOrderTestBuilder.aProductOrder;
import static java.util.Collections.emptyList;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CustomerName;
import be.aca.witb.utility.validation.exceptions.CollectionIsEmptyException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class CreateOrderRequestTest {

	@Test
	public void createsRequestWithValidParameters() {
		CustomerName customerName = aCustomerName();
		CreateCustomerRequest request = new CreateCustomerRequest(customerName);

		assertThat(request.getName().getValue()).isEqualTo(customerName.getValue());
	}

	@Test
	public void throwsExceptionWhenCustomerIdentifierIsNull() {
		assertThatThrownBy(() -> new CreateOrderRequest(null, of(aProductOrder().build()))).isInstanceOf(
				ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenOrderLineRequestsIsNull() {
		assertThatThrownBy(() -> new CreateOrderRequest(aCustomerIdentifier(), null)).isInstanceOf(
				ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenOrderLineRequestsIsEmpty() {
		assertThatThrownBy(() -> new CreateOrderRequest(aCustomerIdentifier(), emptyList())).isInstanceOf(
				CollectionIsEmptyException.class);
	}
}
