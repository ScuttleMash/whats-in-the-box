package be.aca.witb.domain.api.product;

import java.util.UUID;

public interface ProductRepository {

	Product get(ProductIdentifier identifier);

	Product get(UUID uuid);
}
