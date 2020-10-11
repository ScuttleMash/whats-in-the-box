package be.aca.witb.domain.api.order;

import java.util.UUID;

import be.aca.witb.domain.api.AbstractIdentifierTest;

public class OrderIdentifierTest extends AbstractIdentifierTest<OrderIdentifier> {

	@Override
	protected OrderIdentifier createIdentifier(UUID uuid, int version) {
		return new OrderIdentifier(uuid, version);
	}
}
