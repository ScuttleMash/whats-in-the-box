package be.aca.witb.domain.api.product.mothers;

import static be.aca.witb.domain.api.product.builders.CreateProductRequestTestBuilder.aCreateProductRequestTestBuilder;

import java.util.UUID;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.Product;
import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.ProductRepository;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;
import be.aca.witb.domain.internal.product.DefaultCreateProductUseCase;
import be.aca.witb.domain.internal.product.DefaultProductRepository;
import be.aca.witb.domain.internal.product.DefaultUpdateProductStockUseCase;

public class ProductMother {

	private final CreateProductUseCase createProductUseCase;
	private final UpdateProductStockUseCase updateProductStockUseCase;
	private final ProductRepository productRepository;

	private UUID uuid;

	public ProductMother() {
		this.createProductUseCase = new DefaultCreateProductUseCase();
		this.updateProductStockUseCase = new DefaultUpdateProductStockUseCase();
		this.productRepository = new DefaultProductRepository();
	}

	public void setup() {
		CreateProductRequest request = aCreateProductRequestTestBuilder().build();
		uuid = createProductUseCase.execute(request).getUuid();
	}

	public Product getProduct() {
		return productRepository.get(uuid);
	}

	public ProductIdentifier getIdentifier() {
		return getProduct().getIdentifier();
	}

	public void updateStock(UpdateProductStockRequest request) {
		updateProductStockUseCase.execute(getIdentifier(), request);
	}
}


