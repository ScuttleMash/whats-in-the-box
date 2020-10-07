package be.aca.witb.domain.api.product.builders;

import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import be.aca.witb.domain.api.product.ProductIdentifier;

public class ProductIdentifierTestBuilder {

	public static ProductIdentifier aProductIdentifier() {
		return new ProductIdentifier(randomUUID(), nextInt());
	}
}
