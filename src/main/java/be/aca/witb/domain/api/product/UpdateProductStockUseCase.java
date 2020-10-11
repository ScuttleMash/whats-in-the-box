package be.aca.witb.domain.api.product;

public interface UpdateProductStockUseCase {

	ProductIdentifier execute(ProductIdentifier identifier, UpdateProductStockRequest request);

}
