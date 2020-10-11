package be.aca.witb.domain.internal.order;

import be.aca.witb.domain.internal.product.ProductEntity;

public class OrderLineEntity {

	private final ProductEntity product;
	private final int amount;

	public OrderLineEntity(ProductEntity product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}
}
