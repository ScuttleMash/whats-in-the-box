package be.aca.witb.domain.api.customer;

import java.util.UUID;

import be.aca.witb.domain.api.AbstractIdentifierTest;

public class CustomerIdentifierTest extends AbstractIdentifierTest<CustomerIdentifier> {

	@Override
	protected CustomerIdentifier createIdentifier(UUID uuid, int version) {
		return new CustomerIdentifier(uuid, version);
	}
}
