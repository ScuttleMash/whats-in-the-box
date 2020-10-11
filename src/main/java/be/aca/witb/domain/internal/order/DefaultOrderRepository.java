package be.aca.witb.domain.internal.order;

import java.util.ArrayList;
import java.util.List;

import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.api.order.OrderRepository;
import be.aca.witb.domain.internal.order.OrderEntity;
import be.aca.witb.domain.internal.order.exceptions.OrderNotFoundException;

public class DefaultOrderRepository implements OrderRepository {

	private static List<OrderEntity> saved = new ArrayList<>();

	@Override
	public OrderEntity get(OrderIdentifier identifier) {
		return saved.stream()
				.filter(order -> order.getIdentifier().equals(identifier))
				.findFirst()
				.orElseThrow(OrderNotFoundException::new);
	}

	OrderEntity save(OrderEntity order) {
		saved.add(order);
		order.bumpVersion();
		return order;
	}
}
