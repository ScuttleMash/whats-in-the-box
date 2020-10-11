package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.api.product.asserts.ProductAssert.assertThatProduct;
import static be.aca.witb.domain.api.product.builders.CreateProductRequestTestBuilder.aCreateProductRequestTestBuilder;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.aca.witb.domain.api.AbstractPersistenceTest;
import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultProductRepository;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class CreateProductUseCaseTest extends AbstractPersistenceTest {

	@Autowired
	private CreateProductUseCase createProductUseCase;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void createsProductUsingRequestValues() {
		CreateProductRequest request = aCreateProductRequestTestBuilder().build();

		ProductIdentifier identifier = createProductUseCase.execute(request);

		Product product = productRepository.get(identifier);
		assertThatProduct(product).hasName(request.getName()).hasPrice(request.getPrice());
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> createProductUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}
}
