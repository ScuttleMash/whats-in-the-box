package be.aca.witb.domain.internal.order;

import be.aca.witb.domain.api.order.OrderLine;
import be.aca.witb.domain.internal.product.ProductEntity;

public class OrderLineEntity implements OrderLine {

	private final ProductEntity product;
	private final int amount;

	public OrderLineEntity(ProductEntity product, int amount) {
		this.product = product;
		this.amount = amount;
	}

	@Override
	public ProductEntity getProduct() {
		return product;
	}

	@Override
	public int getAmount() {
		return amount;
	}
}
