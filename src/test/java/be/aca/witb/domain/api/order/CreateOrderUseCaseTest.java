package be.aca.witb.domain.api.order;

import static be.aca.witb.domain.api.order.asserts.OrderAssert.assertThatOrder;
import static be.aca.witb.domain.api.order.builders.CreateOrderRequestTestBuilder.aCreateOrderRequestTestBuilder;
import static be.aca.witb.domain.api.order.builders.OrderLineRequestTestBuilder.anOrderLineRequestTestBuilder;
import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.customer.mothers.CustomerMother;
import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.customer.exceptions.CustomerNotFoundException;
import be.aca.witb.domain.internal.order.DefaultCreateOrderUseCase;
import be.aca.witb.domain.internal.order.DefaultOrderRepository;
import be.aca.witb.domain.internal.product.exceptions.ProductNotFoundException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class CreateOrderUseCaseTest {

	private CreateOrderUseCase createOrderUseCase;
	private OrderRepository orderRepository;

	private ProductMother bottleOfWater;
	private ProductMother caseOfOranges;
	private CustomerMother johnDoe;

	@Test
	public void createsOrderThatCanBeFulfilledWhenStockIsAvailable() {
		bottleOfWater.setup();
		bottleOfWater.updateStock(5);
		johnDoe.setup();
		OrderLineRequest bottleOfWaterRequest =
				anOrderLineRequestTestBuilder().withProductIdentifier(bottleOfWater.getIdentifier()).withAmount(2).build();
		CreateOrderRequest request = aCreateOrderRequestTestBuilder().withCustomerIdentifier(johnDoe.getIdentifier())
				.withOrderLineRequests(of(bottleOfWaterRequest))
				.build();

		OrderIdentifier orderIdentifier = createOrderUseCase.execute(request);

		Order order = orderRepository.get(orderIdentifier);
		assertThatOrder(order).canBeFulfilled(true);
	}

	@Test
	public void createsOrderThatCannotBeFulfilledWhenStockIsTooLow() {
		bottleOfWater.setup();
		bottleOfWater.updateStock(5);
		johnDoe.setup();
		OrderLineRequest bottleOfWaterRequest =
				anOrderLineRequestTestBuilder().withProductIdentifier(bottleOfWater.getIdentifier()).withAmount(10).build();
		CreateOrderRequest request = aCreateOrderRequestTestBuilder().withCustomerIdentifier(johnDoe.getIdentifier())
				.withOrderLineRequests(of(bottleOfWaterRequest))
				.build();

		OrderIdentifier orderIdentifier = createOrderUseCase.execute(request);

		Order order = orderRepository.get(orderIdentifier);
		assertThatOrder(order).canBeFulfilled(false);
	}

	@Test
	public void createsOrderWithMultipleProducts() {
		bottleOfWater.setup();
		caseOfOranges.setup();
		johnDoe.setup();
		OrderLineRequest bottleOfWaterRequest = anOrderLineRequestTestBuilder()
				.withProductIdentifier(bottleOfWater.getIdentifier()).withAmount(10).build();
		OrderLineRequest caseOfOrangesRequest = anOrderLineRequestTestBuilder()
				.withProductIdentifier(caseOfOranges.getIdentifier()).withAmount(1).build();
		CreateOrderRequest request = aCreateOrderRequestTestBuilder()
				.withCustomerIdentifier(johnDoe.getIdentifier())
				.withOrderLineRequests(of(bottleOfWaterRequest, caseOfOrangesRequest)).build();

		OrderIdentifier orderIdentifier = createOrderUseCase.execute(request);

		Order order = orderRepository.get(orderIdentifier);
		assertThatOrder(order)
				.containsItems(2)
				.containsItem(bottleOfWater.getIdentifier(), 10)
				.containsItem(caseOfOranges.getIdentifier(), 1);
	}

	@Test
	public void throwsExceptionWhenCustomerDoesNotExist() {
		CreateOrderRequest request = aCreateOrderRequestTestBuilder().build();

		assertThatThrownBy(() -> createOrderUseCase.execute(request)).isInstanceOf(CustomerNotFoundException.class);
	}

	@Test
	public void throwsExceptionWhenProductDoesNotExist() {
		johnDoe.setup();
		CreateOrderRequest request =
				aCreateOrderRequestTestBuilder().withCustomerIdentifier(johnDoe.getIdentifier()).build();

		assertThatThrownBy(() -> createOrderUseCase.execute(request)).isInstanceOf(ProductNotFoundException.class);
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> createOrderUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}

	@BeforeEach
	public void setup() {
		createOrderUseCase = new DefaultCreateOrderUseCase();
		orderRepository = new DefaultOrderRepository();

		bottleOfWater = new ProductMother();
		caseOfOranges = new ProductMother();
		johnDoe = new CustomerMother();
	}

}
