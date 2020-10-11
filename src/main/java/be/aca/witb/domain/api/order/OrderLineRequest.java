package be.aca.witb.domain.api.order;

import static be.aca.witb.utility.validation.Validator.isNotNegative;
import static be.aca.witb.utility.validation.Validator.isNotNull;
import static be.aca.witb.utility.validation.Validator.isNotZero;

import be.aca.witb.domain.api.product.ProductIdentifier;

public final class OrderLineRequest {

	private ProductIdentifier productIdentifier;
	private int amount;

	public OrderLineRequest(ProductIdentifier productIdentifier, int amount) {
		isNotNull(productIdentifier);
		isNotNegative(amount);
		isNotZero(amount);

		this.productIdentifier = productIdentifier;
		this.amount = amount;
	}

	public ProductIdentifier getProductIdentifier() {
		return productIdentifier;
	}

	public int getAmount() {
		return amount;
	}
}
