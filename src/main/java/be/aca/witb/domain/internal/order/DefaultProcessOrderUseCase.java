package be.aca.witb.domain.internal.order;

import static be.aca.witb.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.api.order.ProcessOrderUseCase;

public class DefaultProcessOrderUseCase implements ProcessOrderUseCase {

	private final DefaultOrderRepository orderRepository;
	private final OrderManager orderManager;

	public DefaultProcessOrderUseCase() {
		orderRepository = new DefaultOrderRepository();
		orderManager = new OrderManager();
	}

	@Override
	public void execute(OrderIdentifier identifier) {
		isNotNull(identifier);

		OrderEntity order = orderRepository.get(identifier);
		order.process();

		orderManager.updateAvailableOrdersForProcessing();

		orderRepository.save(order);
	}
}
