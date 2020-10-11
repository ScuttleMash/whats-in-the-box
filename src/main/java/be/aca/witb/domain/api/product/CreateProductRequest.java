package be.aca.witb.domain.api.product;

import static be.aca.witb.utility.validation.Validator.isNotNull;

public final class CreateProductRequest {

	private final ProductName name;
	private final ProductPrice price;

	public CreateProductRequest(ProductName name, ProductPrice price) {
		isNotNull(name);
		isNotNull(price);

		this.name = name;
		this.price = price;
	}

	public ProductName getName() {
		return name;
	}

	public ProductPrice getPrice() {
		return price;
	}
}
