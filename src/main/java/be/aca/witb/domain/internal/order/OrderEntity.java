package be.aca.witb.domain.internal.order;

import static java.util.List.copyOf;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

import java.util.List;

import be.aca.witb.domain.api.order.Order;
import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.api.order.OrderLine;
import be.aca.witb.domain.internal.customer.CustomerEntity;

public class OrderEntity implements Order {

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
	public List<OrderLine> getOrderLines() {
		return copyOf(orderLines);
	}

	@Override
	public boolean canBeFulfilled() {
		return orderLines.stream().allMatch(item -> item.getProduct().hasAmountInStock(item.getAmount()));
	}

	public void process() {
		// Process the order.
	}
}
