package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.api.product.asserts.ProductAssert.assertThatProduct;
import static be.aca.witb.domain.api.product.builders.ProductIdentifierTestBuilder.aProductIdentifier;
import static be.aca.witb.domain.api.product.builders.ProductNameTestBuilder.aProductName;
import static be.aca.witb.domain.api.product.builders.UpdateProductNameRequestTestBuilder.anUpdateProductNameRequestTestBuilder;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.product.DefaultUpdateProductNameUseCase;
import be.aca.witb.domain.internal.product.exceptions.ProductNotFoundException;
import be.aca.witb.domain.utility.validation.exceptions.ObjectIsNullException;

public class UpdateProductNameUseCaseTest {

	private ProductMother productMother;
	private UpdateProductNameUseCase updateProductNameUseCase;

	@BeforeEach
	public void setup() {
		productMother = new ProductMother();
		updateProductNameUseCase = new DefaultUpdateProductNameUseCase();
	}

	@Test
	public void updatesNameOfProduct() {
		productMother.setup();
		ProductName updatedName = aProductName();
		UpdateProductNameRequest request = anUpdateProductNameRequestTestBuilder().withProductName(updatedName).build();

		updateProductNameUseCase.execute(productMother.getIdentifier(), request);

		assertThatProduct(productMother.getProduct()).hasName(updatedName);
	}

	@Test
	public void throwsExceptionWhenProductNotFound() {
		ProductIdentifier identifier = aProductIdentifier();
		UpdateProductNameRequest request = anUpdateProductNameRequestTestBuilder().build();

		assertThatThrownBy(() -> updateProductNameUseCase.execute(identifier, request)).isInstanceOf(
				ProductNotFoundException.class);

	}

	@Test
	public void throwsExceptionWhenIdentifierIsNull() {
		UpdateProductNameRequest request = anUpdateProductNameRequestTestBuilder().build();

		assertThatThrownBy(() -> updateProductNameUseCase.execute(null, request)).isInstanceOf(ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		ProductIdentifier identifier = aProductIdentifier();

		assertThatThrownBy(() -> updateProductNameUseCase.execute(identifier, null)).isInstanceOf(
				ObjectIsNullException.class);
	}
}
