package be.aca.witb.domain.internal.order;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import java.util.List;

import be.aca.witb.domain.api.order.Order;
import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.internal.customer.CustomerEntity;

public class OrderEntity implements Order {

	private static final int LARGE_ORDER_TRESHOLD = 5;

	private String uuid;
	private int version;

	private CustomerEntity customer;
	private List<OrderLineEntity> orderLines;

	public OrderEntity(CustomerEntity customer, List<OrderLineEntity> orderLines) {
		uuid = randomUUID().toString();
		version = 1;

		this.customer = customer;
		this.orderLines = orderLines;
	}

	public OrderIdentifier getIdentifier() {
		return new OrderIdentifier(fromString(uuid), version);
	}

	public void bumpVersion() {
		version++;
	}

	@Override
	public boolean canBeFulfilled() {
		return orderLines.stream().allMatch(item -> item.getProduct().hasAmountInStock(item.getAmount()));
	}
}
