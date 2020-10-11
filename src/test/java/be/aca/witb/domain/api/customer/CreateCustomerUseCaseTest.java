package be.aca.witb.domain.api.customer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.internal.customer.DefaultCreateCustomerUseCase;
import be.aca.witb.domain.utility.validation.exceptions.ObjectIsNullException;

public class CreateCustomerUseCaseTest {

	private CreateCustomerUseCase createCustomerUseCase;

	@BeforeEach
	public void setup() {
		createCustomerUseCase = new DefaultCreateCustomerUseCase();
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> createCustomerUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}
}
