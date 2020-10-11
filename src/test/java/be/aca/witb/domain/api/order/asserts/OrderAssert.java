package be.aca.witb.domain.api.order.asserts;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import be.aca.witb.domain.api.order.Order;

public final class OrderAssert extends AbstractAssert<OrderAssert, Order> {

	public OrderAssert(Order order) {
		super(order, OrderAssert.class);
	}

	public OrderAssert canBeFulfilled(boolean expected) {
		assertThat(actual.canBeFulfilled()).isEqualTo(expected);
		return this;
	}

	public static OrderAssert assertThatOrder(Order order) {
		assertThat(order).isNotNull();
		return new OrderAssert(order);
	}
}

