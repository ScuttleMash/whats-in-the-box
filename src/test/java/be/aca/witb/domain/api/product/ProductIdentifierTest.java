package be.aca.witb.domain.api.product;

import java.util.UUID;

import be.aca.witb.domain.api.AbstractIdentifierTest;

public class ProductIdentifierTest extends AbstractIdentifierTest<ProductIdentifier> {

	@Override
	protected ProductIdentifier createIdentifier(UUID uuid, int version) {
		return new ProductIdentifier(uuid, version);
	}
}
