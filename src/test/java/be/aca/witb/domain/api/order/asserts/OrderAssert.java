package be.aca.witb.domain.api.order.asserts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import org.assertj.core.api.AbstractAssert;

import be.aca.witb.domain.api.order.Order;
import be.aca.witb.domain.api.order.OrderLine;
import be.aca.witb.domain.api.product.ProductIdentifier;

public final class OrderAssert extends AbstractAssert<OrderAssert, Order> {

	public OrderAssert(Order order) {
		super(order, OrderAssert.class);
	}

	public OrderAssert canBeFulfilled(boolean expected) {
		assertThat(actual.canBeFulfilled()).isEqualTo(expected);
		return this;
	}

	public OrderAssert containsItem(ProductIdentifier identifier, int amount) {
		assertThat(actual.getOrderLines()).extracting(line -> line.getProduct().getIdentifier(), OrderLine::getAmount)
				.contains(tuple(identifier, amount));
		return this;
	}

	public OrderAssert containsItems(int expected) {
		assertThat(actual.getOrderLines()).hasSize(expected);
		return this;
	}

	public static OrderAssert assertThatOrder(Order order) {
		assertThat(order).isNotNull();
		return new OrderAssert(order);
	}
}

