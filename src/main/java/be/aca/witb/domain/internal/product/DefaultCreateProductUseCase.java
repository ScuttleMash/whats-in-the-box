package be.aca.witb.domain.internal.product;

import static be.aca.witb.domain.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.ProductIdentifier;

public class DefaultCreateProductUseCase implements CreateProductUseCase {

	private final DefaultProductRepository productRepository;

	public DefaultCreateProductUseCase() {
		this.productRepository = new DefaultProductRepository();
	}

	@Override
	public ProductIdentifier execute(CreateProductRequest request) {
		isNotNull(request);

		ProductEntity product = productRepository.save(new ProductEntity(request));

		return product.getIdentifier();
	}
}
