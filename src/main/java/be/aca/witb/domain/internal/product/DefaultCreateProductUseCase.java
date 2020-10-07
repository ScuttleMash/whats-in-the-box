package be.aca.witb.domain.internal.product;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.utility.validation.Validator;

public class DefaultCreateProductUseCase implements CreateProductUseCase {

	private final DefaultProductRepository productRepository;

	public DefaultCreateProductUseCase() {
		productRepository = new DefaultProductRepository();
	}

	@Override
	public ProductIdentifier execute(CreateProductRequest request) {
		Validator.isNotNull(request);

		ProductEntity product = productRepository.save(new ProductEntity(request));

		return product.getIdentifier();
	}
}
