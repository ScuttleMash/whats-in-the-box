package be.aca.witb.domain.internal.order;

import static be.aca.witb.domain.utility.validation.Validator.isNotNull;

import be.aca.witb.domain.api.order.CreateOrderRequest;
import be.aca.witb.domain.api.order.CreateOrderUseCase;
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
	public void execute(CreateOrderRequest request) {
		isNotNull(request);

		ProductEntity product = productRepository.get(request.getProductIdentifier());
		CustomerEntity customer = customerRepository.get(request.getCustomerIdentifier());

		orderRepository.save(new OrderEntity(product, customer));
	}
}
