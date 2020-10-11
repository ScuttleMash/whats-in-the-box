package be.aca.witb.domain.api.product;

import static be.aca.witb.utility.validation.Validator.hasMaxLength;
import static be.aca.witb.utility.validation.Validator.isNotBlank;

public final class ProductName {

	private static final int MAX_PRODUCT_NAME_LENGTH = 20;

	private final String value;

	public ProductName(String value) {
		isNotBlank(value);
		hasMaxLength(value, MAX_PRODUCT_NAME_LENGTH);

		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
