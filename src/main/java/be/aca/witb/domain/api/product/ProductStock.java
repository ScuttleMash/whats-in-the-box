package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.utility.validation.Validator.isNotNegative;

public final class ProductStock {

	private final int value;

	public ProductStock(int value) {
		isNotNegative(value);

		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
