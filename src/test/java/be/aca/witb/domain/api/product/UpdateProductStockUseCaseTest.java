package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.api.product.asserts.ProductAssert.assertThatProduct;
import static be.aca.witb.domain.api.product.builders.ProductIdentifierTestBuilder.aProductIdentifier;
import static be.aca.witb.domain.api.product.builders.UpdateProductStockRequestTestBuilder.anUpdateProductStockRequest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.product.DefaultUpdateProductStockUseCase;
import be.aca.witb.domain.internal.product.exceptions.ProductNotFoundException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class UpdateProductStockUseCaseTest {

	private ProductMother productMother;
	private UpdateProductStockUseCase updateProductStockUseCase;

	@BeforeEach
	public void setup() {
		productMother = new ProductMother();
		updateProductStockUseCase = new DefaultUpdateProductStockUseCase();
	}

	@Test
	public void updatesStockOfProduct() {
		productMother.setup();
		UpdateProductStockRequest request = anUpdateProductStockRequest().build();

		updateProductStockUseCase.execute(productMother.getIdentifier(), request);

		assertThatProduct(productMother.getProduct()).hasStock(request.getProductStock());
	}

	@Test
	public void throwsExceptionWhenProductNotFound() {
		ProductIdentifier identifier = aProductIdentifier();
		UpdateProductStockRequest request = anUpdateProductStockRequest().build();

		assertThatThrownBy(() -> updateProductStockUseCase.execute(identifier, request)).isInstanceOf(
				ProductNotFoundException.class);
	}

	@Test
	public void throwsExceptionWhenIdentifierIsNull() {
		UpdateProductStockRequest request = anUpdateProductStockRequest().build();

		assertThatThrownBy(() -> updateProductStockUseCase.execute(null, request)).isInstanceOf(ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		ProductIdentifier identifier = aProductIdentifier();

		assertThatThrownBy(() -> updateProductStockUseCase.execute(identifier, null)).isInstanceOf(
				ObjectIsNullException.class);
	}
}
