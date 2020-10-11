package be.aca.witb.domain.api.order;

public interface OrderRepository {

	Order get(OrderIdentifier identifier);
}
