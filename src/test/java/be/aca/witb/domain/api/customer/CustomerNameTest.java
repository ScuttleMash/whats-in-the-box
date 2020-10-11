package be.aca.witb.domain.api.customer;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
;
import be.aca.witb.utility.validation.exceptions.StringIsBlankException;
import be.aca.witb.utility.validation.exceptions.StringIsTooLongException;

public class CustomerNameTest {

	@Test
	public void createCustomerNameWithMinimumViableLength() {
		String value = randomAlphanumeric(1);
		CustomerName productName = new CustomerName(value);

		assertThat(productName.getValue()).isEqualTo(value);
	}

	@Test
	public void createCustomerNameWithMaximumViableLength() {
		String value = randomAlphanumeric(30);
		CustomerName productName = new CustomerName(value);

		assertThat(productName.getValue()).isEqualTo(value);
	}

	@Test
	public void throwsExceptionWhenCustomerPriceIsBlank() {
		assertThatThrownBy(() -> new CustomerName(" \t \r \n ")).isInstanceOf(StringIsBlankException.class);
	}

	@Test
	public void throwsExceptionWhenCustomerNameIsTooLong() {
		assertThatThrownBy(() -> new CustomerName(randomAlphanumeric(31))).isInstanceOf(StringIsTooLongException.class);
	}
}
