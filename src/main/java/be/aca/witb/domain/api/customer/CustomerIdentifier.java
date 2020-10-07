package be.aca.witb.domain.api.customer;

import java.util.Objects;
import java.util.UUID;

import be.aca.witb.utility.validation.Validator;

public final class CustomerIdentifier {

	private final UUID uuid;
	private final int version;

	public CustomerIdentifier(UUID uuid, int version) {
		Validator.isNotNull(uuid);
		Validator.isNotNegative(version);

		this.uuid = uuid;
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CustomerIdentifier that = (CustomerIdentifier) o;
		return version == that.version && Objects.equals(uuid, that.uuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, version);
	}
}
