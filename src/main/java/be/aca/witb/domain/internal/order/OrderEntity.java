package be.aca.witb.domain.internal.order;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.internal.customer.CustomerEntity;
import be.aca.witb.domain.internal.product.ProductEntity;

public class OrderEntity {

	private String uuid;
	private int version;

	private ProductEntity product;
	private CustomerEntity customer;

	public OrderEntity(ProductEntity product, CustomerEntity customer) {
		uuid = randomUUID().toString();
		version = 1;

		this.product = product;
		this.customer = customer;
	}

	public OrderIdentifier getIdentifier() {
		return new OrderIdentifier(fromString(uuid), version);
	}

	public void bumpVersion() {
		version++;
	}
}
