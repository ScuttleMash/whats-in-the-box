package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.api.product.asserts.ProductAssert.assertThatProduct;
import static be.aca.witb.domain.api.product.builders.CreateProductRequestTestBuilder.aCreateProductRequestTestBuilder;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultProductRepository;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class CreateProductUseCaseTest {

	private CreateProductUseCase createProductUseCase;
	private ProductRepository productRepository;

	@BeforeEach
	public void setup() {
		createProductUseCase = new DefaultCreateProductUseCase();
		productRepository = new DefaultProductRepository();
	}

	@Test
	public void createsProductUsingRequestValues() {
		CreateProductRequest request = aCreateProductRequestTestBuilder().build();

		ProductIdentifier identifier = createProductUseCase.execute(request);

		Product product = productRepository.get(identifier);
		assertThatProduct(product).hasName(request.getName()).hasPrice(request.getPrice());
	}

	@Test
	public void productIsCreatedWithNoStock() {
		CreateProductRequest request = aCreateProductRequestTestBuilder().build();

		ProductIdentifier identifier = createProductUseCase.execute(request);

		Product product = productRepository.get(identifier);
		assertThatProduct(product).hasNoStock();
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> createProductUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}
}
