package be.aca.witb.domain.internal.customer;

import static be.aca.witb.domain.api.customer.builders.CreateCustomerRequestTestBuilder.aCreateCustomerRequestTestBuilder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import be.aca.witb.domain.api.AbstractPersistenceTest;
import be.aca.witb.domain.api.customer.CreateCustomerRequest;
import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.customer.CustomerIdentifier;
import be.aca.witb.domain.internal.customer.asserts.UglyCustomerAssert;

public class UglyCreateCustomerUseCaseTest extends AbstractPersistenceTest {

	@Autowired
	private CreateCustomerUseCase createCustomerUseCase;

	@Autowired
	private DefaultCustomerRepository defaultCustomerRepository;

	@Test
	public void createsCustomerUsingRequestValues() {
		CreateCustomerRequest request = aCreateCustomerRequestTestBuilder().build();

		CustomerIdentifier identifier = createCustomerUseCase.execute(request);

		CustomerEntity customer = defaultCustomerRepository.get(identifier);
		UglyCustomerAssert.assertThatCustomer(customer).hasName(request.getName());
	}
}
