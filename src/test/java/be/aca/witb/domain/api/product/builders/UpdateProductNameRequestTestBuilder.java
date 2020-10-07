package be.aca.witb.domain.api.product.builders;

import static be.aca.witb.domain.api.product.builders.ProductNameTestBuilder.aProductName;

import be.aca.witb.domain.api.product.ProductName;
import be.aca.witb.domain.api.product.UpdateProductNameRequest;

public final class UpdateProductNameRequestTestBuilder {

	private ProductName productName;

	private UpdateProductNameRequestTestBuilder() {
		productName = aProductName();
	}

	public UpdateProductNameRequest build() {
		return new UpdateProductNameRequest(productName);
	}

	public UpdateProductNameRequestTestBuilder withProductName(ProductName productName) {
		this.productName = productName;
		return this;
	}

	public static UpdateProductNameRequestTestBuilder anUpdateProductNameRequestTestBuilder() {
		return new UpdateProductNameRequestTestBuilder();
	}
}
