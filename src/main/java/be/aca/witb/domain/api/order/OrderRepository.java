package be.aca.witb.domain.api.order;

import java.util.UUID;

public interface OrderRepository {

	Order get(OrderIdentifier identifier);

	Order get(UUID uuid);
}
