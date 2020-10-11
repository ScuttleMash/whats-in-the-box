package be.aca.witb.domain.utility.validation;

import org.apache.commons.lang3.StringUtils;

import be.aca.witb.domain.utility.validation.exceptions.DoubleIsNegativeException;
import be.aca.witb.domain.utility.validation.exceptions.IntegerIsNegativeException;
import be.aca.witb.domain.utility.validation.exceptions.ObjectIsNullException;
import be.aca.witb.domain.utility.validation.exceptions.StringIsBlankException;
import be.aca.witb.domain.utility.validation.exceptions.StringIsTooLongException;

public class Validator {

	public static void isNotNull(Object value) {
		if (value == null) {
			throw new ObjectIsNullException();
		}
	}

	public static void isNotBlank(String value) {
		if (StringUtils.isBlank(value)) {
			throw new StringIsBlankException();
		}
	}

	public static void hasMaxLength(String value, int maxLength) {
		if (value.length() > maxLength) {
			throw new StringIsTooLongException();
		}
	}

	public static void isNotNegative(int value) {
		if (value < 0) {
			throw new IntegerIsNegativeException();
		}
	}

	public static void isNotNegative(double value) {
		if (value < 0.0) {
			throw new DoubleIsNegativeException();
		}
	}
}
