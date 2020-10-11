package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.ProductRepository;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;

public class DefaultUpdateProductStockUseCase implements UpdateProductStockUseCase {

	private final DefaultProductRepository productRepository;

	public DefaultUpdateProductStockUseCase() {
		productRepository = new DefaultProductRepository();
	}

	@Override
	public ProductIdentifier execute(ProductIdentifier identifier, UpdateProductStockRequest request) {
		isNotNull(identifier);
		isNotNull(request);

		ProductEntity product = productRepository.get(identifier);
		product.updateStock(request);

		productRepository.save(product);
		return product.getIdentifier();
	}

}
