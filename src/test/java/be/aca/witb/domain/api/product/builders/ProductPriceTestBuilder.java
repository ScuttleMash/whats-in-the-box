package be.aca.witb.domain.api.product.builders;

import static org.apache.commons.lang3.RandomUtils.nextDouble;

import be.aca.witb.domain.api.product.ProductPrice;

public final class ProductPriceTestBuilder {

	private ProductPriceTestBuilder() { }

	public static ProductPrice aProductPrice() {
		return new ProductPrice(nextDouble());
	}

}
