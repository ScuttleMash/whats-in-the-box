package be.aca.witb.domain.api.product.builders;

import static java.lang.Integer.MAX_VALUE;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import be.aca.witb.domain.api.product.ProductStock;

public final class ProductStockTestBuilder {

	private int value;

	private ProductStockTestBuilder() {
		value = nextInt(1, MAX_VALUE);
	}

	public ProductStock build() {
		return new ProductStock(value);
	}

	public ProductStockTestBuilder withValue(int value) {
		this.value = value;
		return this;
	}

	public static ProductStockTestBuilder aProductStock() {
		return new ProductStockTestBuilder();
	}

}
