package be.aca.witb.domain.api.order.builders;

import static be.aca.witb.domain.api.product.builders.ProductIdentifierTestBuilder.aProductIdentifier;
import static java.lang.Integer.*;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import be.aca.witb.domain.api.order.OrderLineRequest;
import be.aca.witb.domain.api.product.ProductIdentifier;

public class OrderLineRequestTestBuilder {

	private ProductIdentifier productIdentifier;
	private int amount;

	private OrderLineRequestTestBuilder() {
		productIdentifier = aProductIdentifier();
		amount = nextInt(1, MAX_VALUE);
	}

	public OrderLineRequest build() {
		return new OrderLineRequest(productIdentifier, amount);
	}

	public OrderLineRequestTestBuilder withProductIdentifier(ProductIdentifier productIdentifier) {
		this.productIdentifier = productIdentifier;
		return this;
	}

	public OrderLineRequestTestBuilder withAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public static OrderLineRequestTestBuilder anOrderLineRequestTestBuilder() {
		return new OrderLineRequestTestBuilder();
	}
}
