import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.order.CreateOrderUseCase;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.internal.customer.DefaultCreateCustomerUseCase;
import be.aca.witb.domain.internal.order.DefaultCreateOrderUseCase;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;

module org.mash.witb {

	exports be.aca.witb.domain.api.customer;
	exports be.aca.witb.domain.api.order;
	exports be.aca.witb.domain.api.product;

	requires org.apache.commons.lang3;

	provides CreateCustomerUseCase with DefaultCreateCustomerUseCase;
	provides CreateProductUseCase with DefaultCreateProductUseCase;
	provides CreateOrderUseCase with DefaultCreateOrderUseCase;
}
