package be.aca.witb.domain.api.product.builders;

import static be.aca.witb.domain.api.product.builders.ProductStockTestBuilder.aProductStock;

import be.aca.witb.domain.api.product.ProductStock;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;

public final class UpdateProductStockRequestTestBuilder {

	private ProductStock productStock;

	private UpdateProductStockRequestTestBuilder() {
		productStock = aProductStock().build();
	}

	public UpdateProductStockRequest build() {
		return new UpdateProductStockRequest(productStock);
	}

	public static UpdateProductStockRequestTestBuilder anUpdateProductStockRequest() {
		return new UpdateProductStockRequestTestBuilder();
	}

	public UpdateProductStockRequestTestBuilder withProductStock(ProductStock productStock) {
		this.productStock = productStock;
		return this;
	}
}
