package be.aca.witb.domain.api.order;

public interface CreateOrderUseCase {

	OrderIdentifier execute(CreateOrderRequest request);

}
