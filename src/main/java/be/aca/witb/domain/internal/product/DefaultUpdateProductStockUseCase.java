package be.aca.witb.domain.internal.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;
import be.aca.witb.domain.internal.order.OrderManager;

public class DefaultUpdateProductStockUseCase implements UpdateProductStockUseCase {

	private final DefaultProductRepository productRepository;
	private final OrderManager orderManager;

	public DefaultUpdateProductStockUseCase() {
		productRepository = new DefaultProductRepository();
		orderManager = new OrderManager();
	}

	@Override
	public ProductIdentifier execute(ProductIdentifier identifier,
			UpdateProductStockRequest request) {
		isNotNull(identifier);
		isNotNull(request);

		ProductEntity product = productRepository.get(identifier);
		product.updateStock(request);

		orderManager.updateAvailableOrdersForProcessing();

		productRepository.save(product);
		return product.getIdentifier();
	}

}
