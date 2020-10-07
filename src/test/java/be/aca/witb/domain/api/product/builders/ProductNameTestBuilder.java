package be.aca.witb.domain.api.product.builders;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import be.aca.witb.domain.api.product.ProductName;

public final class ProductNameTestBuilder {

	private static final int MIN_LENGTH_INCLUSIVE = 1;
	private static final int MAX_LENGTH_EXCLUSIVE = 21;

	private ProductNameTestBuilder() { }

	public static ProductName aProductName() {
		return new ProductName(randomAlphanumeric(MIN_LENGTH_INCLUSIVE, MAX_LENGTH_EXCLUSIVE));
	}
}
