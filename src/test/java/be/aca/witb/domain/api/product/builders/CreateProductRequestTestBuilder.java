package be.aca.witb.domain.api.product.builders;

import static be.aca.witb.domain.api.product.builders.ProductNameTestBuilder.aProductName;
import static be.aca.witb.domain.api.product.builders.ProductPriceTestBuilder.aProductPrice;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.ProductName;
import be.aca.witb.domain.api.product.ProductPrice;

public final class CreateProductRequestTestBuilder {

	private ProductName productName;
	private ProductPrice productPrice;

	private CreateProductRequestTestBuilder() {
		productName = aProductName();
		productPrice = aProductPrice();
	}

	public CreateProductRequest build() {
		return new CreateProductRequest(productName, productPrice);
	}

	public CreateProductRequestTestBuilder withProductName(ProductName productName) {
		this.productName = productName;
		return this;
	}

	public CreateProductRequestTestBuilder withProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
		return this;
	}

	public static CreateProductRequestTestBuilder aCreateProductRequestTestBuilder() {
		return new CreateProductRequestTestBuilder();
	}
}
