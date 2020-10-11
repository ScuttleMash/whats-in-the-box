package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.utility.validation.Validator.isNotNegative;

public final class ProductPrice {

	private final double value;

	public ProductPrice(double value) {
		isNotNegative(value);

		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
