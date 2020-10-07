package be.aca.witb.domain.api.product;

import be.aca.witb.utility.validation.Validator;

public final class CreateProductRequest {

	private final ProductName name;
	private final ProductPrice price;

	public CreateProductRequest(ProductName name, ProductPrice price) {
		Validator.isNotNull(name);
		Validator.isNotNull(price);

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
