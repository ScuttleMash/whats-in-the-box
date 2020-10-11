package be.aca.witb.domain.api.product.mothers;

import static be.aca.witb.domain.api.product.builders.CreateProductRequestTestBuilder.aCreateProductRequestTestBuilder;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.aca.witb.domain.api.product.CreateProductRequest;
import be.aca.witb.domain.api.product.CreateProductUseCase;
import be.aca.witb.domain.api.product.Product;
import be.aca.witb.domain.api.product.ProductIdentifier;
import be.aca.witb.domain.api.product.ProductRepository;
import be.aca.witb.domain.api.product.UpdateProductStockRequest;
import be.aca.witb.domain.api.product.UpdateProductStockUseCase;

@Component
public class ProductMother {

	private final CreateProductUseCase createProductUseCase;
	private final UpdateProductStockUseCase updateProductStockUseCase;
	private final ProductRepository productRepository;

	private UUID uuid;

	@Autowired
	public ProductMother(CreateProductUseCase createProductUseCase, UpdateProductStockUseCase updateProductStockUseCase,
			ProductRepository productRepository) {
		this.createProductUseCase = createProductUseCase;
		this.updateProductStockUseCase = updateProductStockUseCase;
		this.productRepository = productRepository;
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


