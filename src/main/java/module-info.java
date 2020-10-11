import be.aca.witb.domain.api.customer.CreateCustomerUseCase;
import be.aca.witb.domain.api.order.CreateOrderUseCase;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.UpdateProductNameUseCase;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;
import be.aca.witb.domain.internal.customer.DefaultCreateCustomerUseCase;
import be.aca.witb.domain.internal.order.DefaultCreateOrderUseCase;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultUpdateProductNameUseCase;
import be.aca.witb.domain.internal.product.DefaultUpdateProductStockUseCase;

open module be.aca.witb.domain {

	exports be.aca.witb.domain.api.customer;
	exports be.aca.witb.domain.api.order;
	exports be.aca.witb.domain.api.product;

	requires org.apache.commons.lang3;

	provides CreateCustomerUseCase with DefaultCreateCustomerUseCase;
	provides CreateProductUseCase with DefaultCreateProductUseCase;
	provides UpdateProductNameUseCase with DefaultUpdateProductNameUseCase;
	provides UpdateProductStockUseCase with DefaultUpdateProductStockUseCase;
	provides CreateOrderUseCase with DefaultCreateOrderUseCase;
}
