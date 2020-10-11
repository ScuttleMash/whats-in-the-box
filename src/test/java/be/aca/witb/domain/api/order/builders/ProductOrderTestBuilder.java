package be.aca.witb.domain.api.order.builders;

import static be.aca.witb.domain.api.product.builders.ProductIdentifierTestBuilder.aProductIdentifier;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import be.aca.witb.domain.api.order.OrderLineRequest;
import be.aca.witb.domain.api.product.ProductIdentifier;

public final class ProductOrderTestBuilder {

	private ProductIdentifier identifier;
	private int amount;

	private ProductOrderTestBuilder() {
		identifier = aProductIdentifier();
		amount = nextInt();
	}

	public OrderLineRequest build() {
		return new OrderLineRequest(identifier, amount);
	}

	public static ProductOrderTestBuilder aProductOrder() {
		return new ProductOrderTestBuilder();
	}

}
