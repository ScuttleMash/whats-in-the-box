package be.aca.witb.utility.validation;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import be.aca.witb.utility.validation.exceptions.CollectionIsEmptyException;
import be.aca.witb.utility.validation.exceptions.DoubleIsNegativeException;
import be.aca.witb.utility.validation.exceptions.IntegerIsNegativeException;
import be.aca.witb.utility.validation.exceptions.IntegerIsZeroException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;
import be.aca.witb.utility.validation.exceptions.StringIsBlankException;
import be.aca.witb.utility.validation.exceptions.StringIsTooLongException;

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

	public static void isNotZero(int value) {
		if (value == 0) {
			throw new IntegerIsZeroException();
		}
	}

	public static void isNotNegative(double value) {
		if (value < 0.0) {
			throw new DoubleIsNegativeException();
		}
	}

	public static void isNotEmpty(Collection value) {
		if (value.isEmpty()) {
			throw new CollectionIsEmptyException();
		}
	}
}
