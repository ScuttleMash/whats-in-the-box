package be.aca.witb.domain.api.order;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.customer.CustomerIdentifier;
import be.aca.witb.domain.api.product.ProductIdentifier;

public final class CreateOrderRequest {

	private final ProductIdentifier productIdentifier;
	private final CustomerIdentifier customerIdentifier;

	public CreateOrderRequest(ProductIdentifier productIdentifier, CustomerIdentifier customerIdentifier) {
		isNotNull(productIdentifier);
		isNotNull(customerIdentifier);

		this.productIdentifier = productIdentifier;
		this.customerIdentifier = customerIdentifier;
	}

	public ProductIdentifier getProductIdentifier() {
		return productIdentifier;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return customerIdentifier;
	}
}
