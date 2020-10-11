package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.api.product.builders.ProductNameTestBuilder.aProductName;
import static be.aca.witb.domain.api.product.builders.ProductPriceTestBuilder.aProductPrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import be.aca.witb.domain.utility.validation.exceptions.ObjectIsNullException;

public class CreateProductRequestTest {

	@Test
	public void createsRequestWithValidParameters() {
		ProductName productName = aProductName();
		ProductPrice productPrice = aProductPrice();
		CreateProductRequest request = new CreateProductRequest(productName, productPrice);

		assertThat(request.getName().getValue()).isEqualTo(productName.getValue());
		assertThat(request.getPrice().getValue()).isEqualTo(productPrice.getValue());
	}

	@Test
	public void throwsExceptionWhenProductNameIsNull() {
		assertThatThrownBy(() -> new CreateProductRequest(null, aProductPrice())).isInstanceOf(ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenProductPriceIsNull() {
		assertThatThrownBy(() -> new CreateProductRequest(aProductName(), null)).isInstanceOf(ObjectIsNullException.class);
	}
}
