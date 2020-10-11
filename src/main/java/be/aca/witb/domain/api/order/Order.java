package be.aca.witb.domain.api.order;

import java.util.List;

public interface Order {

	List<OrderLine> getOrderLines();

	boolean canBeFulfilled();

}
