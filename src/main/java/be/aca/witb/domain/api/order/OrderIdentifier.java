package be.aca.witb.domain.api.order;

import static be.aca.witb.domain.utility.validation.Validator.isNotNegative;
import static be.aca.witb.domain.utility.validation.Validator.isNotNull;

import java.util.Objects;
import java.util.UUID;

public final class OrderIdentifier {

	private final UUID uuid;
	private final int version;

	public OrderIdentifier(UUID uuid, int version) {
		isNotNull(uuid);
		isNotNegative(version);

		this.uuid = uuid;
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		OrderIdentifier that = (OrderIdentifier) o;
		return version == that.version && Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, version);
	}
}
