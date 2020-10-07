package be.aca.witb.domain.api.product;

public interface UpdateProductNameUseCase {

	ProductIdentifier execute(ProductIdentifier identifier, UpdateProductNameRequest request);

}
