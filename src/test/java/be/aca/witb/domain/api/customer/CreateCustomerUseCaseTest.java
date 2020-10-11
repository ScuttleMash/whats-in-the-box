package be.aca.witb.domain.api.customer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.aca.witb.domain.api.AbstractPersistenceTest;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class CreateCustomerUseCaseTest extends AbstractPersistenceTest {

	@Autowired
	private CreateCustomerUseCase createCustomerUseCase;

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> createCustomerUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}
}
