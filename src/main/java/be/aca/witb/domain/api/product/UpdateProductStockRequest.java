package be.aca.witb.domain.api.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

public class UpdateProductStockRequest {

	private final ProductStock productStock;

	public UpdateProductStockRequest(ProductStock productStock) {
		isNotNull(productStock);

		this.productStock = productStock;
	}

	public ProductStock getProductStock() {
		return productStock;
	}
}
