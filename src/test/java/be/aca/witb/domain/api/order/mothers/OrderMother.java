package be.aca.witb.domain.api.order.mothers;

import static be.aca.witb.domain.api.order.builders.CreateOrderRequestTestBuilder.aCreateOrderRequestTestBuilder;
import static be.aca.witb.domain.api.order.builders.OrderLineRequestTestBuilder.anOrderLineRequestTestBuilder;
import static java.util.List.of;

import java.util.UUID;

import be.aca.witb.domain.api.customer.mothers.CustomerMother;
import be.aca.witb.domain.api.order.CreateOrderUseCase;
import be.aca.witb.domain.api.order.Order;
import be.aca.witb.domain.api.order.OrderRepository;
import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.order.DefaultCreateOrderUseCase;
import be.aca.witb.domain.internal.order.DefaultOrderRepository;

public class OrderMother {

	private OrderRepository orderRepository;
	private CreateOrderUseCase createOrderUseCase;
	private CustomerMother customerMother;
	private ProductMother productMother;

	private UUID orderUuid;

	public OrderMother() {
		orderRepository = new DefaultOrderRepository();
		createOrderUseCase = new DefaultCreateOrderUseCase();
		customerMother = new CustomerMother();
		productMother = new ProductMother();
	}

	public void setup() {
		customerMother.setup();
		productMother.setup();
		orderUuid = createOrderUseCase.execute(
				aCreateOrderRequestTestBuilder().withCustomerIdentifier(customerMother.getIdentifier())
						.withOrderLineRequests(
								of(anOrderLineRequestTestBuilder().withProductIdentifier(productMother.getIdentifier())
										.build()))
						.build()).getUuid();
	}

	public Order getOrder() {
		return orderRepository.get(orderUuid);
	}
}
