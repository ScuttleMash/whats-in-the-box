package be.aca.witb.domain.api.product;

import static org.apache.commons.lang3.RandomUtils.nextDouble;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.utility.validation.exceptions.DoubleIsNegativeException;

public class ProductPriceTest {

	@Test
	public void createProductPriceWithValue() {
		double value = nextDouble();
		ProductPrice productPrice = new ProductPrice(value);

		assertThat(productPrice.getValue()).isEqualTo(value);
	}

	@Test
	public void throwsExceptionWhenProductPriceIsNegative() {
		assertThatThrownBy(() -> new ProductPrice(-1.0)).isInstanceOf(DoubleIsNegativeException.class);
	}
}
