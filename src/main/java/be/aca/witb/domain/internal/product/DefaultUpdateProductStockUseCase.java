package be.aca.witb.domain.internal.product;

import be.aca.witb.utility.modules.ModuleServiceProvider;
import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;

public class DefaultUpdateProductStockUseCase implements UpdateProductStockUseCase {

	@Override
	public ProductIdentifier execute(ProductIdentifier identifier, UpdateProductStockRequest request) {
		return null;
	}

	public static UpdateProductStockUseCase provider() {
		return ModuleServiceProvider.provide(UpdateProductStockUseCase.class);
	}
}
