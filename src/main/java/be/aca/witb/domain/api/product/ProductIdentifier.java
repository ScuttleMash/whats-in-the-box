package be.aca.witb.domain.api.product;

import static be.aca.witb.utility.validation.Validator.isNotNegative;
import static be.aca.witb.utility.validation.Validator.isNotNull;

import java.util.Objects;
import java.util.UUID;

public final class ProductIdentifier {

	private final UUID uuid;
	private final int version;

	public ProductIdentifier(UUID uuid, int version) {
		isNotNull(uuid);
		isNotNegative(version);

		this.uuid = uuid;
		this.version = version;
	}

	public UUID getUuid() {
		return uuid;
	}

	public boolean hasUuid(UUID uuid) {
		return this.uuid.equals(uuid);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ProductIdentifier that = (ProductIdentifier) o;
		return version == that.version && Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, version);
	}
}
