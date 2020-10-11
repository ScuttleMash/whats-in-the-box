package be.aca.witb.domain.api.product;

import static be.aca.witb.domain.utility.validation.Validator.isNotNull;

public final class UpdateProductNameRequest {

	private final ProductName productName;

	public UpdateProductNameRequest(ProductName productName) {
		isNotNull(productName);

		this.productName = productName;
	}

	public ProductName getProductName() {
		return productName;
	}
}
