package be.aca.witb.domain.api.order;

import static be.aca.witb.domain.api.product.builders.ProductIdentifierTestBuilder.aProductIdentifier;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.utility.validation.exceptions.IntegerIsNegativeException;
import be.aca.witb.utility.validation.exceptions.IntegerIsZeroException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class OrderLineRequestTest {

	@Test
	public void createProductOrderWithValidValues() {
		ProductIdentifier identifier = aProductIdentifier();
		OrderLineRequest orderLineRequest = new OrderLineRequest(identifier, 10);

		assertThat(orderLineRequest.getProductIdentifier()).isEqualTo(identifier);
		assertThat(orderLineRequest.getAmount()).isEqualTo(10);
	}

	@Test
	public void throwsExceptionWhenIdentifierIsNull() {
		assertThatThrownBy(() -> new OrderLineRequest(null, 1)).isInstanceOf(ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenAmountIsNegative() {
		assertThatThrownBy(() -> new OrderLineRequest(aProductIdentifier(), -1)).isInstanceOf(IntegerIsNegativeException.class);
	}

	@Test
	public void throwsExceptionWhenAmountIsZero() {
		assertThatThrownBy(() -> new OrderLineRequest(aProductIdentifier(), 0)).isInstanceOf(IntegerIsZeroException.class);
	}
}
