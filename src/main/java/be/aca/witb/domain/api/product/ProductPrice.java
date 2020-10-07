package be.aca.witb.domain.api.product;

import static be.aca.witb.utility.validation.Validator.isNotNegative;

import be.aca.witb.utility.validation.Validator;

public final class ProductPrice {

	private final double value;

	public ProductPrice(double value) {
		Validator.isNotNegative(value);

		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
