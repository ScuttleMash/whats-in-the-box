package be.aca.witb.domain.api.customer;

public interface CreateCustomerUseCase {

	CustomerIdentifier execute(CreateCustomerRequest request);

}
