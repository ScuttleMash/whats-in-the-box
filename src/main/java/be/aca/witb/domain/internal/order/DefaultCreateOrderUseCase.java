package be.aca.witb.domain.internal.order;

import static be.aca.witb.utility.validation.Validator.isNotNull;
import static java.util.stream.Collectors.toList;

import java.util.List;

import be.aca.witb.domain.api.order.CreateOrderRequest;
import be.aca.witb.domain.api.order.CreateOrderUseCase;
import be.aca.witb.domain.api.order.OrderIdentifier;
import be.aca.witb.domain.api.order.OrderLineRequest;
import be.aca.witb.domain.internal.customer.CustomerEntity;
import be.aca.witb.domain.internal.customer.DefaultCustomerRepository;
import be.aca.witb.domain.internal.product.DefaultProductRepository;
import be.aca.witb.domain.internal.product.ProductEntity;

public class DefaultCreateOrderUseCase implements CreateOrderUseCase {

	private final DefaultOrderRepository orderRepository;
	private final DefaultProductRepository productRepository;
	private final DefaultCustomerRepository customerRepository;

	public DefaultCreateOrderUseCase() {
		orderRepository = new DefaultOrderRepository();
		productRepository = new DefaultProductRepository();
		customerRepository = new DefaultCustomerRepository();
	}

	@Override
	public OrderIdentifier execute(CreateOrderRequest request) {
		isNotNull(request);

		CustomerEntity customer = customerRepository.get(request.getCustomerIdentifier());
		List<OrderLineEntity> orderLines = request.getOrderLineRequests().stream().map(this::toOrderLine).collect(toList());

		OrderEntity order = orderRepository.save(new OrderEntity(customer, orderLines));
		return order.getIdentifier();
	}

	private OrderLineEntity toOrderLine(OrderLineRequest request) {
		ProductEntity product = productRepository.get(request.getProductIdentifier());
		return new OrderLineEntity(product, request.getAmount());
	}
}
