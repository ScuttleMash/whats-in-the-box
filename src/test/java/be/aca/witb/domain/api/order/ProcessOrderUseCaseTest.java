package be.aca.witb.domain.api.order;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.aca.witb.domain.api.order.mothers.OrderMother;
import be.aca.witb.domain.internal.order.DefaultProcessOrderUseCase;
import be.aca.witb.utility.validation.exceptions.ObjectIsNullException;

public class ProcessOrderUseCaseTest {

	private ProcessOrderUseCase processOrderUseCase;

	@BeforeEach
	public void setup() {
		processOrderUseCase = new DefaultProcessOrderUseCase();
	}

	@Test
	public void throwsExceptionWhenRequestIsNull() {
		assertThatThrownBy(() -> processOrderUseCase.execute(null)).isInstanceOf(ObjectIsNullException.class);
	}
}

