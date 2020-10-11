package be.aca.witb.domain.api.product;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.utility.validation.exceptions.StringIsBlankException;
import be.aca.witb.utility.validation.exceptions.StringIsTooLongException;

public class ProductNameTest {

	@Test
	public void createProductNameWithMinimumViableLength() {
		String value = randomAlphanumeric(1);
		ProductName productName = new ProductName(value);

		assertThat(productName.getValue()).isEqualTo(value);
	}

	@Test
	public void createProductNameWithMaximumViableLength() {
		String value = randomAlphanumeric(20);
		ProductName productName = new ProductName(value);

		assertThat(productName.getValue()).isEqualTo(value);
	}

	@Test
	public void throwsExceptionWhenProductPriceIsBlank() {
		assertThatThrownBy(() -> new ProductName(" \t \r \n ")).isInstanceOf(StringIsBlankException.class);
	}

	@Test
	public void throwsExceptionWhenProductNameIsTooLong() {
		assertThatThrownBy(() -> new ProductName(randomAlphanumeric(21))).isInstanceOf(StringIsTooLongException.class);
	}
}
