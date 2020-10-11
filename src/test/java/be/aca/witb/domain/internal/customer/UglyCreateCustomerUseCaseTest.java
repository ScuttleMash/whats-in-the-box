	package be.aca.witb.domain.internal.customer;

	import static be.aca.witb.domain.api.customer.builders.CreateCustomerRequestTestBuilder.aCreateCustomerRequestTestBuilder;
	import static java.time.ZonedDateTime.*;

	import java.time.LocalDate;
	import java.time.ZonedDateTime;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import be.aca.witb.domain.api.customer.CreateCustomerRequest;
	import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
	import be.aca.witb.domain.api.customer.CustomerIdentifier;
	import be.aca.witb.domain.internal.customer.asserts.UglyCustomerAssert;

	public class UglyCreateCustomerUseCaseTest {

		private CreateCustomerUseCase createCustomerUseCase;
		private DefaultCustomerRepository defaultCustomerRepository;

		@BeforeEach
		public void setup() {
			createCustomerUseCase = new DefaultCreateCustomerUseCase();
			defaultCustomerRepository = new DefaultCustomerRepository();
		}

		@Test
		public void registrationDateIsKeptWhenCustomerIsCreated() {
			CreateCustomerRequest request = aCreateCustomerRequestTestBuilder().build();

			CustomerIdentifier identifier = createCustomerUseCase.execute(request);

			CustomerEntity customer = defaultCustomerRepository.get(identifier);
			UglyCustomerAssert.assertThatCustomer(customer).wasRegisteredOn(now());
		}
	}
