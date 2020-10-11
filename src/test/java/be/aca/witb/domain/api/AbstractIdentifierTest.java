package be.aca.witb.domain.api;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import be.aca.witb.utility.validation.exceptions.IntegerIsNegativeException;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public abstract class AbstractIdentifierTest<T> {

	protected abstract T createIdentifier(UUID uuid, int version);

	@Test
	public void isEqualWhenUUIDAndVersionAreEqual() {
		UUID leftUuid = randomUUID();
		T leftIdentifier = createIdentifier(leftUuid, 1);
		UUID rightUuid = fromString(leftUuid.toString());
		T rightIdentifier = createIdentifier(rightUuid, 1);

		assertThat(leftIdentifier.equals(rightIdentifier)).isTrue();
	}

	@Test
	public void isNotEqualWhenUUIDsAreDifferent() {
		T leftIdentifier = createIdentifier(randomUUID(), 1);
		T rightIdentifier = createIdentifier(randomUUID(), 1);

		assertThat(leftIdentifier.equals(rightIdentifier)).isFalse();
	}

	@Test
	public void isNotEqualWhenVersionsAreDifferent() {
		UUID uuid = randomUUID();
		T leftIdentifier = createIdentifier(uuid, 1);
		T rightIdentifier = createIdentifier(uuid, 2);

		assertThat(leftIdentifier.equals(rightIdentifier)).isFalse();
	}

	@Test
	public void throwsExceptionWhenUUIDIsNull() {
		assertThatThrownBy(() -> createIdentifier(null, nextInt())).isInstanceOf(ObjectIsNullException.class);
	}

	@Test
	public void throwsExceptionWhenVersionIsNegative() {
		assertThatThrownBy(() -> createIdentifier(randomUUID(), -1)).isInstanceOf(IntegerIsNegativeException.class);
	}
}
