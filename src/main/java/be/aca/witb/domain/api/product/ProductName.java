package be.aca.witb.domain.api.product;

import be.aca.witb.utility.validation.Validator;

public final class ProductName {

	private static final int MAX_PRODUCT_NAME_LENGTH = 20;

	private final String value;

	public ProductName(String value) {
		Validator.isNotBlank(value);
		Validator.hasMaxLength(value, MAX_PRODUCT_NAME_LENGTH);

		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
