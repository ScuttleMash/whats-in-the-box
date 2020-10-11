package be.aca.witb.domain.api.order;

import org.junit.jupiter.api.BeforeEach;

import be.aca.witb.domain.api.customer.mothers.CustomerMother;
import be.aca.witb.domain.api.product.mothers.ProductMother;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultProductRepository;

public class UpdateOrderUseCaseTest {

	private ProductMother productMother;
	private CustomerMother customerMother;

	@BeforeEach
	public void setup() {
		productMother = new ProductMother();
		customerMother = new CustomerMother();
	}


}
