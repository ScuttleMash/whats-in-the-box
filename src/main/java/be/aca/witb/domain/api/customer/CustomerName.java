package be.aca.witb.domain.api.customer;

import static be.aca.witb.utility.validation.Validator.hasMaxLength;
import static be.aca.witb.utility.validation.Validator.isNotBlank;

public class CustomerName {

	private static final int MAX_CUSTOMER_NAME_LENGTH = 30;

	private final String value;

	public CustomerName(String value) {
		isNotBlank(value);
		hasMaxLength(value, MAX_CUSTOMER_NAME_LENGTH);

		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
