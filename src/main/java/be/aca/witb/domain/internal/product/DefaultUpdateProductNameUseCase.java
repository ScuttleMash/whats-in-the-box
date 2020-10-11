package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.UpdateProductNameRequest;
import be.aca.witb.domain.api.product.UpdateProductNameUseCase;

public class DefaultUpdateProductNameUseCase implements UpdateProductNameUseCase {

	private final DefaultProductRepository productRepository;

	public DefaultUpdateProductNameUseCase() {
		this.productRepository = new DefaultProductRepository();
	}

	@Override
	public ProductIdentifier execute(ProductIdentifier identifier, UpdateProductNameRequest request) {
		isNotNull(identifier);
		isNotNull(request);

		ProductEntity product = productRepository.get(identifier);
		product.updateName(request);

		productRepository.save(product);
		return product.getIdentifier();
	}
}
